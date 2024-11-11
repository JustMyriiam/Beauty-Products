package com.ecommerce.beautyproducts.service;

import com.ecommerce.beautyproducts.entity.Category;
import com.ecommerce.beautyproducts.model.CategoryResponse;
import com.ecommerce.beautyproducts.repository.CategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        log.info("Fetching all categories");
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponse> categoryResponseList = categoryList.stream()
                .map(this::convertToCategoryResponse)
                .collect(Collectors.toList());
        log.info("Fetched all categories");
        return categoryResponseList;
    }

    private CategoryResponse convertToCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
