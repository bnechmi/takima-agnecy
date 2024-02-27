package io.takima.agencymanagement.model;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum ConnectionManager {
    INSTANCE;

    private final String JDBC_URL = "jdbc:postgresql://localhost:5432/agencymanagement_db";
    private final String JDBC_USER = "madmin";
    private final String JDBC_PASSWORD = "madmin";

    private static final HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/agencymanagement_db");
        config.setUsername("madmin");
        config.setPassword("madmin");
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    /*public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }*/
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}