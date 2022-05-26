package com.solvd.taxi.myBatisClass;

import com.solvd.taxi.dao.ICallOperatorsDAO;
import com.solvd.taxi.models.CallOperatorsModel;
import com.solvd.taxi.utilites.MyBatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class CallOperators {
    private static final Logger LOGGER = LogManager.getLogger(CallOperators.class);

    public void createCallOperators(CallOperatorsModel callOperatorsModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            ICallOperatorsDAO callOperatorsDAO = sqlSession.getMapper(ICallOperatorsDAO.class);
            callOperatorsDAO.createCallOperators(callOperatorsModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateCallOperators(CallOperatorsModel callOperatorsModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            ICallOperatorsDAO callOperatorsDAO = sqlSession.getMapper(ICallOperatorsDAO.class);
            callOperatorsDAO.updateCallOperatorsById(callOperatorsModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteCallOperatorsById(CallOperatorsModel callOperatorsModel) {
        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try {
            ICallOperatorsDAO callOperatorsDAO = sqlSession.getMapper(ICallOperatorsDAO.class);
            callOperatorsDAO.deleteCallOperatorsById(callOperatorsModel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public CallOperatorsModel getCallOperatorsById(Integer id) throws IOException {

        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        CallOperatorsModel callOperatorsModel;
        try {
            ICallOperatorsDAO callOperatorsDAO = session.getMapper(ICallOperatorsDAO.class);
            callOperatorsModel = callOperatorsDAO.getCallOperatorsById(id);
            LOGGER.info(callOperatorsModel);
        } finally {
            session.close();
        }
        return callOperatorsModel;
    }
}

