package com.solvd.taxi.utilites;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatis {
    private static SqlSessionFactory factory;

    private MyBatis() {
    }
    static
    {
        Reader rdr = null;
        try {
            rdr = Resources.getResourceAsReader("mybatis_config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(rdr);
    }

    public static SqlSessionFactory getSqlSessionFactory()
    {
        return factory;
    }
}
