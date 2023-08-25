package com.boutique_ekinox.Repository;

import com.boutique_ekinox.Model.Buy;
import com.boutique_ekinox.Model.Client;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class BuyDAO extends UniversalDAO<Buy> {

    public BuyDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Buy> All() throws SQLException {
        List<Buy> listeBuy = new ArrayList<>();
        String sql = "SELECT * FROM buy;";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Buy buy = extractBuyFromResultSet(resultSet);
                listeBuy.add(buy);
            }
        }
        return listeBuy;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM buy WHERE id_client = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
    }

    @Override
    public void insert(Buy Insert) throws SQLException {

    }

    @Override
    public Optional<Buy> selectById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void update(Client Update) throws SQLException {

    }
    private Buy extractBuyFromResultSet(ResultSet resultSet) throws SQLException {
        int id_client = resultSet.getInt("id_client");
        int id_product = resultSet.getInt("id_product");


        return new Buy(id_client, id_product);
    }
}
