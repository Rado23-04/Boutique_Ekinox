package com.boutique_ekinox.Controller;



import com.boutique_ekinox.Model.Client;
import com.boutique_ekinox.Model.Products;
import com.boutique_ekinox.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    public ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/insert_product")
    public Products insertProduct(@RequestBody Products toInsert){
        return productService.insert(toInsert);
    }
    @DeleteMapping("/delete_product/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        productService.deleteProduct(id);
        return "Product successfully deleted";
    }
    @GetMapping("/all_products")
    public List<Products> all() throws SQLException {
        return productService.allProducts();
    }
    @GetMapping("/id_product/{id}")
    public Optional<Products> selectProduct (@PathVariable int id) throws SQLException{
        return productService.IdProduct(id);
    }
}
