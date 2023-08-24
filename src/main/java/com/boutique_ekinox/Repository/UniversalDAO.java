package com.boutique_ekinox.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.List;

public  abstract class UniversalDAO<Z> {
    private Connection connection;

    public UniversalDAO(Connection connection) {
        this.connection = connection;
    }
    public Connection getConnection(){
        return connection ;
    }

    public abstract List<Z> All () throws SQLException;
    public abstract void delete (int id) throws SQLException;
    public abstract void update (Z update) throws SQLException;
    public abstract void insert(Z Insert) throws SQLException;
}
