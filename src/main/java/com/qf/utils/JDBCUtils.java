package com.qf.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    static {
        try {
            Properties pp = new Properties();
            pp.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取数据库连接
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }

    //获取数据库连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

}
