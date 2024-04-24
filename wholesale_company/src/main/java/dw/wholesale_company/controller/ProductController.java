package dw.wholesale_company.controller;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/inventory/under/{num}")
    public ResponseEntity<List<Product>> getProductByInventoryUnder(@PathVariable int num) {
        return new ResponseEntity<>(productService.getProductByInventoryUnder(num),
                HttpStatus.OK);
    }


    @GetMapping("/{productName}")
    public ResponseEntity<List<Product>> getProductByProductName(@PathVariable String productName) {
        return new ResponseEntity<>(productService.getProductByProductName(productName),
                HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<Product>> getProductByPriceRange(@RequestParam int low,
                                                                @RequestParam int high) {
        return new ResponseEntity<>(productService.getProductByPriceRange(low, high),
                HttpStatus.OK);
    }

    @GetMapping("/products/idlist")
    public ResponseEntity<List<Product>> getProductByIdWithList(@RequestBody List<Long> idList) {
        return new ResponseEntity<>(productService.getProductByIdWithList(idList),
                HttpStatus.OK);
    }
}
