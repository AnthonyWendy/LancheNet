package com.br.lanchenet.category.service;

import com.br.lanchenet.category.entity.Category;
import com.br.lanchenet.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Page<Category> doFindAll(Pageable page){
        return categoryRepository.findAll(page);
    }

    public Optional<Category> findOne(Long id){
        Optional<Category> search = categoryRepository.findById(id);
        if(search.isEmpty()) return Optional.empty();
        return search;
    }

    public Category doPost(Category category){
        categoryRepository.save(category);
        return category;
    }

    public Category doPut(Category category){
        categoryRepository.save(category);
        return category;
    }
}
