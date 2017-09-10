package br.com.talles.drink.persistence;

import br.com.talles.drink.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String DBURL;

    public ConnectionFactory() {
        DbConfig dbconfig = new DbConfig();
        DBURL = dbconfig.getDBUrl();
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DBURL, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
