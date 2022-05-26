package com.solvd.taxi.dao.myBatisClassDAO;

import com.solvd.taxi.dao.ICitiesDAO;
import com.solvd.taxi.models.CitiesModel;
import com.solvd.taxi.utilites.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CitiesMyBatisDAO {
    private static final Logger LOGGER = LogManager.getLogger(CitiesMyBatisDAO.class);

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

        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        CitiesModel citiesModel;
        try {
            ICitiesDAO citiesDAO = sqlSession.getMapper(ICitiesDAO.class);
            citiesModel = citiesDAO.getCitiesById(id);
        } finally {
            sqlSession.close();
        }
        return citiesModel;
    }
}
