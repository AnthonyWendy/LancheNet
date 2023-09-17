package com.br.lanchenet.product.entities;

import com.br.lanchenet.category.entity.Category;
import com.br.lanchenet.ingredient.entity.Ingredient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "error.product.name.empty")
    @Size(max = 50)
    private String name;

    @NotNull(message = "error.product.price.empty")
    private BigDecimal price;

    @Size(max = 50)
    private String description;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<ListIngredient> ListIngredient;

    @AssertTrue
    private Boolean active;
}
