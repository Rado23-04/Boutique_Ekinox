package com.boutique_ekinox.Service;

import com.boutique_ekinox.Model.Buy;
import com.boutique_ekinox.Repository.BuyDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class BuyService {
    private BuyDAO buyDAO;
    public BuyService (BuyDAO buyDAO){
        this.buyDAO = buyDAO;
    }
    public List<Buy> allPayments() throws SQLException {
        try {
            return buyDAO.All();
        }catch (SQLException e){
            throw new RuntimeException("An error occurred while finding all the payment.");
        }
    }
    public void deletePayment(int id) throws SQLException {
        buyDAO.delete(id);
    }
}
