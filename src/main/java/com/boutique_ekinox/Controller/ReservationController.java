package com.boutique_ekinox.Controller;

import com.boutique_ekinox.Model.Products;
import com.boutique_ekinox.Model.Reservation;
import com.boutique_ekinox.Service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
public class ReservationController {
    public ReservationService reservationService;
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    @PostMapping("/insert_reservation")
    public Reservation insertReservation(@RequestBody Reservation toInsert){
        return reservationService.insert(toInsert);
    }
    @DeleteMapping("/delete_reservation/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        reservationService.deletereservation(id);
        return "Client successfully deleted";
    }
    @GetMapping("/id_reservation/{id}")
    public Optional<Reservation> selectProduct (@PathVariable int id) throws SQLException{
        return reservationService.IdReservation(id);
    }
}
