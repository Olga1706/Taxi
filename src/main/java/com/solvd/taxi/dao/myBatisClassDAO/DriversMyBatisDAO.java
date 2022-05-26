package com.solvd.taxi.dao.myBatisClassDAO;


import com.solvd.taxi.dao.IDriversDAO;
import com.solvd.taxi.models.DriversModel;
import com.solvd.taxi.utilites.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DriversMyBatisDAO {
    private static final Logger LOGGER = LogManager.getLogger(DriversMyBatisDAO.class);

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

        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        DriversModel driversModel;
        try {
            IDriversDAO driversDAO = sqlSession.getMapper(IDriversDAO.class);
            driversModel = driversDAO.getDriversById(id);
        } finally {
            sqlSession.close();
        }
        return driversModel;
    }
}
