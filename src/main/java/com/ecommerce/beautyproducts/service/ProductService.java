package com.ecommerce.beautyproducts.service;

import com.ecommerce.beautyproducts.model.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(Integer productId);
    Page<ProductResponse> getAllProducts(Pageable pageable);
    List<ProductResponse> searchProductsByName(String keyword);
}
