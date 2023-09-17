package com.br.lanchenet.product.service;

import com.br.lanchenet.category.entity.Category;
import com.br.lanchenet.product.entities.Product;
import com.br.lanchenet.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> doFindAll(Pageable page){
        return productRepository.findAll(page);
    }

    public Optional<Product> findProduct(Long id){
        Optional<Product> search = productRepository.findById(id);
        return search;
    }

    public Product doPost(Product entity){
        setReference(entity);
         productRepository.save(entity);
        return productRepository.getOne(entity.getId());
    }

    public Product doPut(Product product){
        productRepository.save(product);
        return product;
    }

    private void setReference(Product entity){
        entity.getListIngredient().forEach(object -> {
            object.setProduct(entity);
                });
    }
}
