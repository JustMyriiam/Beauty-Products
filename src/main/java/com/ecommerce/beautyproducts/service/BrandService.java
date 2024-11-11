package com.ecommerce.beautyproducts.service;

import com.ecommerce.beautyproducts.entity.Brand;
import com.ecommerce.beautyproducts.model.BrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BrandService {
    List<BrandResponse> getAllBrands();

}
