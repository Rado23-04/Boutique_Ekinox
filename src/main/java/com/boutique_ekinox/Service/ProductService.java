package com.boutique_ekinox.Service;

import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Model.Products;
import com.boutique_ekinox.Repository.ProductsDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductsDAO productsDAO;

    public ProductService(ProductsDAO productsDAO){
        this.productsDAO = productsDAO;
    }
    public Products insert(Products Toinsert){
        try {
            this.productsDAO.insert(Toinsert);
            return Toinsert;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while inserting the product.");
        }
    }
    public void deleteClient(int id) throws SQLException {
        productsDAO.delete(id);
    }
    public List<Products> allProducts() throws SQLException {
        try {
            return productsDAO.All();
        }catch (SQLException e){
            throw new RuntimeException("An error occurred while finding all the products.");
        }
    }
    public Optional<Products> IdProduct (int id)throws SQLException{
        try {
            return productsDAO.selectById(id);
        }catch (SQLException e){
            throw new  RuntimeException("An error occurred while finding the product.");
        }
    }
}
