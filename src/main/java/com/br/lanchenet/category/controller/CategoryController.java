package com.br.lanchenet.category.controller;

import com.br.lanchenet.category.entity.Category;
import com.br.lanchenet.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService serviceCategory;

    @GetMapping("/")
    public ResponseEntity<Page<Category>> findAll(Pageable pageable){
        return ResponseEntity.ok(serviceCategory.doFindAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getOne(@PathVariable Long id){
        Optional<Category> search = serviceCategory.findOne(id);
        return ResponseEntity.accepted().body(search);
    }

    @PostMapping("/")
    public ResponseEntity<Category> postCategory(@RequestBody Category entity){
        Category category = serviceCategory.doPost(entity);
        return ResponseEntity.accepted().body(category);
    }

    @PutMapping("/")
    public ResponseEntity<Category> putCategory(@RequestBody Category entity){
        Category update = serviceCategory.doPut(entity);
        return ResponseEntity.accepted().body(update);
    }
}
