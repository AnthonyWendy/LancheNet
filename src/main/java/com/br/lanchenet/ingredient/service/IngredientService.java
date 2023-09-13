package com.br.lanchenet.ingredient.service;

import com.br.lanchenet.ingredient.entity.Ingredient;
import com.br.lanchenet.ingredient.repository.IngredientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    IngredientRespository ingredientRespository;

    public Page<Ingredient> doFindAll(Pageable pageable){
        return ingredientRespository.findAll(pageable);
    }

    public Optional<Ingredient> findOne(Long id){
        Optional<Ingredient> ingredient = ingredientRespository.findById(id);
        if(ingredient.isEmpty()) return Optional.empty();
        return ingredient;
    }

    public Ingredient doPost(Ingredient ingredient){
        Ingredient newIngredient = ingredientRespository.save(ingredient);
        return newIngredient;
    }

    public Ingredient doPut(Ingredient ingredient){
        Ingredient updateIngredient = ingredientRespository.save(ingredient);
        return updateIngredient;
    }

}
