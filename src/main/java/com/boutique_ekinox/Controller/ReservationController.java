package com.boutique_ekinox.Controller;

import com.boutique_ekinox.Model.Products;
import com.boutique_ekinox.Model.Reservation;
import com.boutique_ekinox.Service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    public ReservationService reservationService;
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    @PostMapping("/insert_reservation")
    public Reservation insertTodo(@RequestBody Reservation toInsert){
        return reservationService.insert(toInsert);
    }
}
