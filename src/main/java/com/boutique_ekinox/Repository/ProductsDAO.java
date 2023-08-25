package com.boutique_ekinox.Repository;

import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Model.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsDAO extends UniversalDAO<Products> {

    public ProductsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Products> All() throws SQLException {
        List<Products> listeProducts = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                Products products = extractProductsFromResultSet(resultSet);
                listeProducts.add(products);
            }
        }
        return listeProducts;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Products update) throws SQLException {

    }

    @Override
    public void insert(Products Insert) throws SQLException {
        String sql = "INSERT INTO products (id, name, description, prix, quantity" +
                "VALUES (?,?,?,?,?)";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, Insert.getId());
            statement.setString(2, Insert.getName());
            statement.setString(3, Insert.getDescription());
            statement.setFloat(4, Insert.getPrice());
            statement.setInt(5, Insert.getQuantity());
            statement.executeUpdate();
        }
    }

    @Override
    public Optional<Client> selectById(int id_products) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id_products);
            statement.executeUpdate();
        }

        return null;
    }

    private Products extractProductsFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        Float price = resultSet.getFloat("price");
        int quantity = resultSet.getInt("quantity");

        return new Products(id,name,description,price,quantity);
    }
}
