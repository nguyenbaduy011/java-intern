package com.example.demoexeptionhandler.controller;

import com.example.demoexeptionhandler.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    // API này luôn ném ra lỗi nếu id != 1
    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {
        if (id != 1) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return "Product Found!";
    }

    // Xử lý exception cục bộ cho controller
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleLocal(ProductNotFoundException ex) {
        return "LOCAL HANDLER: " + ex.getMessage();
    }
}
