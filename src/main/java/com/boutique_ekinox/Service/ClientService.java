package com.boutique_ekinox.Service;

import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Repository.ClientDAO;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClientService {
    private ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {

        this.clientDAO = clientDAO;
    }

    public List<Client> allClients() throws SQLException {
        try {
            return clientDAO.All();
        }catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }
}
