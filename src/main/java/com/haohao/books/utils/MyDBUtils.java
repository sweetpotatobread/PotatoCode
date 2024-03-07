package com.haohao.books.utils;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * 数据库工具类
 */

public class MyDBUtils {
    private static MysqlDataSource dataSource;

    static {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/books?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
    }

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }
}
