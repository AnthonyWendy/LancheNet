package com.br.lanchenet.category.CategoryService;

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

    public Optional<Category> doGetOne(Long id){
        return categoryRepository.findById(id);
    }
}
