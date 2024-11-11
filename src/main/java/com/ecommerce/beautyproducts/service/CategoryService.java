package com.ecommerce.beautyproducts.service;

import com.ecommerce.beautyproducts.model.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
}
