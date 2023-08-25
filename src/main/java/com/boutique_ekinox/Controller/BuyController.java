package com.boutique_ekinox.Controller;

import com.boutique_ekinox.Model.Buy;
import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Service.BuyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BuyController {
    public BuyService buyService;
    public BuyController (BuyService buyService){
        this.buyService = buyService;
    }
    @GetMapping("/all_payments")
    public List<Buy> all() throws SQLException {
        return buyService.allPayments();
    }
    @DeleteMapping("/delete_payment/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        buyService.deletePayment(id);
        return "Payment successfully deleted ";
    }
}
