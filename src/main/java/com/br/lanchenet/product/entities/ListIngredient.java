package com.br.lanchenet.product.entities;

import com.br.lanchenet.ingredient.entity.Ingredient;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Ingredient ingredient;

    @ManyToOne
    private Product product;
}
