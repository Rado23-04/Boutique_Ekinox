package com.boutique_ekinox.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Client {
    private int id_client;
    private String credit_card;
    private String first_name;
    private String last_name;
    private String birthday;
    private String address;
    private String CIN;
}