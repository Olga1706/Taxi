package com.solvd.taxi.utilites;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatis {
    private static SqlSessionFactory factory;

    public MyBatis() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        Reader rdr = null;
            try {
                rdr = Resources.getResourceAsReader("mappers/mybatis_config.xml");
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            factory = new SqlSessionFactoryBuilder().build(rdr);
        return factory;
    }
}
