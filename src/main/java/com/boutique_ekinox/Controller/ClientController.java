package com.boutique_ekinox.Controller;

import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ClientController {

    public ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/ping")
    public String pingPong(){
        return "pong";
    }
    @GetMapping("/clients")
    public List<Client> all() throws SQLException {
        return clientService.allClients();
    }
}
