package com.br.lanchenet.ingredient.repository;

import com.br.lanchenet.category.entity.Category;
import com.br.lanchenet.ingredient.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRespository extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findById(Long id);

}
