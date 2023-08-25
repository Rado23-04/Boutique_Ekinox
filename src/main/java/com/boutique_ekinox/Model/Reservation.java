package com.boutique_ekinox.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Reservation {
    private int id_reservation;
    private String reservation_date;
    private int id_client;
    private int id_product;


}
