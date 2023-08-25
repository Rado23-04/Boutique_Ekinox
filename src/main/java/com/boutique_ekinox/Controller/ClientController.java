package com.boutique_ekinox.Controller;

import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/all_clients")
    public List<Client> all() throws SQLException {
        return clientService.allClients();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        clientService.deleteClient(id);
        return "Client successfully deleted ";
    }
    @GetMapping("/id_client/{id}")
    public Optional<Client> selectClient (@PathVariable int id) throws SQLException{
        return clientService.IdClient(id);
    }
        @PostMapping("/insert_client")
        public Client insertTodo(@RequestBody Client toInsert){
            return clientService.insert(toInsert);
        }
}
