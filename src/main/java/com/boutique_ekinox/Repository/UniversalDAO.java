package com.boutique_ekinox.Repository;

import com.boutique_ekinox.Model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    public abstract void insert(Z Insert) throws SQLException;
    public abstract Optional<Z> selectById(int id) throws SQLException;

    public abstract void update(Client Update) throws SQLException;
}
