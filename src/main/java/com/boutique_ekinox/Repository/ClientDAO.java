package com.boutique_ekinox.Repository;

import com.boutique_ekinox.Model.Client;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ClientDAO extends UniversalDAO<Client> {

    public ClientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Client> All() throws SQLException {
        List<Client> listeClient = new ArrayList<>();
        String sql = "SELECT * FROM client;";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Client client = extractClientFromResultSet(resultSet);
                listeClient.add(client);
            }
        }
        return listeClient;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Client update) throws SQLException {
        String sql = "UPDATE client SET first_name = ?, last_name = ?, birthday = ?, address = ? where id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1,update.getFirst_name());
            statement.setString(2,update.getLast_name());
            statement.setString(3,update.getBirthday());
            statement.setString(4,update.getAddress());
            statement.setInt(5,update.getId_client());
            statement.executeUpdate();
        }
    }

    @Override
    public void insert(Client Insert) throws SQLException {
        String sql = "INSERT INTO client (id_client,credit_card,first_name,last_name,birthday,address,cin)"+
                "VALUES (?,?,?,?,?,?,?)";

        try ( PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1,Insert.getId_client());
            statement.setString(2,Insert.getCredit_card());
            statement.setString(3, Insert.getFirst_name());
            statement.setString(4, Insert.getLast_name());
            statement.setString(5, Insert.getBirthday());
            statement.setString(6,Insert.getAddress());
            statement.setString(7, Insert.getCIN());
            statement.executeUpdate();
        }
    }
    private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id_client");
        String credit_card = resultSet.getString("credit_card");
        String first_name = resultSet.getString("first_name");
        String last_name = resultSet.getString("last_name");
        String birthday = resultSet.getString("birthday");
        String address = resultSet.getString("address");
        String cin = resultSet.getString("cin");

        return new Client(id,credit_card,first_name,last_name,birthday,address,cin);
    }
}
