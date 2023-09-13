package com.br.lanchenet.ingredient.controller;

import com.br.lanchenet.ingredient.entity.Ingredient;
import com.br.lanchenet.ingredient.entity.Ingredient;
import com.br.lanchenet.ingredient.repository.IngredientRespository;
import com.br.lanchenet.ingredient.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("ingredient")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/")
    public ResponseEntity<Page<Ingredient>> findAll(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(ingredientService.doFindAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ingredient>> getOne(@PathVariable Long id){
        Optional<Ingredient> search = ingredientService.findOne(id);
        return ResponseEntity.accepted().body(search);
    }

    @PostMapping("/")
    public ResponseEntity<Ingredient> postIngredient(@RequestBody Ingredient entity){
        Ingredient ingredient = ingredientService.doPost(entity);
        return ResponseEntity.accepted().body(ingredient);
    }

    @PutMapping("/")
    public ResponseEntity<Ingredient> putIngredient(@RequestBody Ingredient entity){
        Ingredient update = ingredientService.doPut(entity);
        return ResponseEntity.accepted().body(update);
    }
}
