package com.boutique_ekinox.Controller;

import com.boutique_ekinox.Model.Buy;
import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Service.BuyService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
    @PostMapping("/insert_payment")
    public Buy insertPayment(@RequestBody Buy toInsert){
        return buyService.insert(toInsert);
    }
    @GetMapping("/id_payment/{id}")
    public Optional<Buy> selectClient (@PathVariable int id) throws SQLException{
        return buyService.IdBuy(id);
    }
}
