package com.boutique_ekinox.Controller;



import com.boutique_ekinox.Model.Products;
import com.boutique_ekinox.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductController {
    public ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/aaa")
    public String pingPong(){
        return "iiii";
    }
    @PostMapping("/insert_product")
    public Products insertTodo(@RequestBody Products toInsert){
        return productService.insert(toInsert);
    }
    @DeleteMapping("/delete_product/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        productService.deleteClient(id);
        return "Client successfully deleted";
    }
    @GetMapping("/products")
    public List<Products> all() throws SQLException {
        return productService.allProducts();
    }
}
