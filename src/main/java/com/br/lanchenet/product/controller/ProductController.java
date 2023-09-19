package com.br.lanchenet.product.controller;

import com.br.lanchenet.category.entity.Category;
import com.br.lanchenet.product.entities.Product;
import com.br.lanchenet.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Page<Product>> findAll(Pageable pageable){
        return ResponseEntity.ok(productService.doFindAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getOne(@PathVariable Long id){
        Optional<Product> search = productService.getOne(id);
        return ResponseEntity.accepted().body(search);
    }

    @PostMapping("/")
    public ResponseEntity<Product> postProduct(@RequestBody Product entity){
        Product newEntity = productService.doPost(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }

    @PutMapping("/")
    public ResponseEntity<Product> putProduct(@RequestBody Product entity){
        Product updateEntity = productService.doPut(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateEntity);
    }
}
