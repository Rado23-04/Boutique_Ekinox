package com.boutique_ekinox.Service;

import com.boutique_ekinox.Model.Buy;
import com.boutique_ekinox.Repository.BuyDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
    public Buy insert(Buy toInsert) {
        try {
            this.buyDAO.insert(toInsert);
            return toInsert;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while inserting the payment.");
        }
    }
    public Optional<Buy> IdBuy (int id)throws SQLException{
        try {
            return buyDAO.selectById(id);
        }catch (SQLException e){
            throw new  RuntimeException("An error occurred while finding the payment.");
        }
    }
}
