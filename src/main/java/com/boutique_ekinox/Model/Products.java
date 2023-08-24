package com.boutique_ekinox.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Products {
    private int id;
    private String name;
    private String description;
    private float price;
    private int quantity;
}
