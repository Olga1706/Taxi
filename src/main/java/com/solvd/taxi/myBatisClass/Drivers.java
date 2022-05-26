package com.solvd.taxi.myBatisClass;


import com.solvd.taxi.dao.IDriversDAO;
import com.solvd.taxi.models.DriversModel;
import com.solvd.taxi.utilites.MyBatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class Drivers {
    private static final Logger LOGGER = LogManager.getLogger(Drivers.class);

    public void createDrivers(DriversModel driversModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            IDriversDAO driversDAO = sqlSession.getMapper(IDriversDAO.class);
            driversDAO.createDriver(driversModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateDrivers(DriversModel driversModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            IDriversDAO driversDAO = sqlSession.getMapper(IDriversDAO.class);
            driversDAO.updateDriverById(driversModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteDriversById(DriversModel driversModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            IDriversDAO driversDAO = sqlSession.getMapper(IDriversDAO.class);
            driversDAO.deleteDriversById(driversModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public DriversModel getDriversById(Integer id) throws IOException {

        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        DriversModel driversModel;
        try {
            IDriversDAO driversDAO = session.getMapper(IDriversDAO.class);
            driversModel = driversDAO.getDriversById(id);
            LOGGER.info(driversModel);
        } finally {
            session.close();
        }
        return driversModel;
    }
}
