package com.itczh.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
 * 获取连接或释放连接的工具类
 */
public class JDBCTools {
    // 1、创建数据源,即连接池
    private static DataSource dataSource;

    // 2、创建ThreadLocal对象
    private static ThreadLocal<Connection> threadLocal;

    static {
        try {
            //1、读取druip.properties文件
            Properties pro = new Properties();
            pro.load(JDBCTools.class.getClassLoader().getResourceAsStream("druid.properties"));

            //2、连接连接池
            dataSource = DruidDataSourceFactory.createDataSource(pro);

            //3、创建线程池
            threadLocal = new ThreadLocal<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接的方法
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() {
        // 从线程中获取连接
        Connection connection = threadLocal.get();
        if (connection == null) {
            // 从连接池中获取一个连接
            try {
                connection = dataSource.getConnection();
                // 将连接与当前线程绑定
                threadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 释放连接的方法
     *
     */
    public static void releaseConnection() {
        // 获取当前线程中的连接
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.close();
                // 将已经关闭的连接从当前线程中移除
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
