package com.boutique_ekinox.Repository;

import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Model.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ReservationDAO extends UniversalDAO<Reservation> {

    public ReservationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Reservation> All() throws SQLException {
        List<Reservation> listeReservation = new ArrayList<>();
        String sql = "SELECT * FROM reservation;";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Reservation reservation = extractReservationFromResultSet(resultSet);
                listeReservation.add(reservation);
            }
        }
        return listeReservation;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM reservation WHERE id_reservation = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
    }

    @Override
    public void insert(Reservation Insert) throws SQLException {
        String sql = "INSERT INTO reservation (id_reservation, id_client, id_product, reservation_date)"+
                "VALUES (?, ?, ?, ?)";

        try ( PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1,Insert.getId_reservation());
            statement.setInt(2,Insert.getId_client());
            statement.setInt(3, Insert.getId_product());
            statement.setString(4, Insert.getReservation_date());

            statement.executeUpdate();
        }
    }

    @Override
    public Optional<Reservation> selectById(int id) throws SQLException {
        String sql = "SELECT * FROM reservation WHERE id_reservation = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(extractReservationFromResultSet(resultSet));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Client Update) throws SQLException {

    }
    private Reservation extractReservationFromResultSet(ResultSet resultSet) throws SQLException {
        int id_reservation = resultSet.getInt("id_reservation");
        int id_client = resultSet.getInt("id_client");
        int id_product = resultSet.getInt("id_product");
        String reservation_date = resultSet.getString("reservation_date");

        return new Reservation(id_reservation,reservation_date,id_product,id_client);
    }
}
