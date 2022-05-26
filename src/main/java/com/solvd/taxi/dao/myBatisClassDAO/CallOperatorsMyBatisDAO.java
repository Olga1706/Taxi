package com.solvd.taxi.dao.myBatisClassDAO;

import com.solvd.taxi.dao.ICallOperatorsDAO;
import com.solvd.taxi.models.CallOperatorsModel;
import com.solvd.taxi.utilites.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CallOperatorsMyBatisDAO {
    private static final Logger LOGGER = LogManager.getLogger(CallOperatorsMyBatisDAO.class);

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

        SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();

        CallOperatorsModel callOperatorsModel;
        try {
            ICallOperatorsDAO callOperatorsDAO = sqlSession.getMapper(ICallOperatorsDAO.class);
            callOperatorsModel = callOperatorsDAO.getCallOperatorsById(id);
        } finally {
            sqlSession.close();
        }
        return callOperatorsModel;
    }
}

