package com.solvd.taxi.myBatisClass;

import com.solvd.taxi.dao.ICitiesDAO;
import com.solvd.taxi.models.CitiesModel;
import com.solvd.taxi.utilites.MyBatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class Cities {
    private static final Logger LOGGER = LogManager.getLogger(Cities.class);

    public void createCities(CitiesModel citiesModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            ICitiesDAO citiesDAO = sqlSession.getMapper(ICitiesDAO.class);
            citiesDAO.createCities(citiesModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateCities(CitiesModel citiesModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            ICitiesDAO citiesDAO = sqlSession.getMapper(ICitiesDAO.class);
            citiesDAO.updateCitiesById(citiesModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteCitiesById(CitiesModel citiesModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            ICitiesDAO citiesDAO = sqlSession.getMapper(ICitiesDAO.class);
            citiesDAO.deleteCitiesById(citiesModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public CitiesModel getCitiesById(Integer id) throws IOException {

        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        CitiesModel citiesModel;
        try {
            ICitiesDAO citiesDAO = session.getMapper(ICitiesDAO.class);
            citiesModel = citiesDAO.getCitiesById(id);
            LOGGER.info(citiesModel);
        } finally {
            session.close();
        }
        return citiesModel;
    }
}
