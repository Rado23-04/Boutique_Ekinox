package com.boutique_ekinox.Service;

import com.boutique_ekinox.Model.Products;
import com.boutique_ekinox.Model.Reservation;
import com.boutique_ekinox.Repository.ReservationDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class ReservationService {
    private ReservationDAO reservationDAO;
    public ReservationService(ReservationDAO reservationDAO){
        this.reservationDAO = reservationDAO;
    }
    public Reservation insert(Reservation Toinsert){
        try {
            this.reservationDAO.insert(Toinsert);
            return Toinsert;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while inserting the reservation.");
        }
    }
    public void deletereservation(int id) throws SQLException {
        reservationDAO.delete(id);
    }
    public Optional<Reservation> IdReservation (int id)throws SQLException{
        try {
            return reservationDAO.selectById(id);
        }catch (SQLException e){
            throw new  RuntimeException("An error occurred while finding the reservation.");
        }
    }
}
