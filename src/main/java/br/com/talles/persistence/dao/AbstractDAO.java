package br.com.talles.persistence.dao;

import br.com.talles.persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO implements IDao {
    protected Connection conn;

	public void openConnection() {
        conn = new ConnectionFactory().getConnection();
    }
	
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
}
