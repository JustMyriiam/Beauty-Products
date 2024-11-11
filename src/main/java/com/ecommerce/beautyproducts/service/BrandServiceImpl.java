package com.ecommerce.beautyproducts.service;

import com.ecommerce.beautyproducts.entity.Brand;
import com.ecommerce.beautyproducts.model.BrandResponse;
import com.ecommerce.beautyproducts.repository.BrandRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService{
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandResponse> getAllBrands() {
       log.info("Fetching all brands!!!");
       List<Brand> brandList   = brandRepository.findAll();
       // stream operator to map with response
        List<BrandResponse> brandResponseList = brandList.stream()
                .map(this::convertToBrandResponse)
                .collect(Collectors.toList());
        log.info("Fetched all brands!!!");
        return brandResponseList;
    }

    private BrandResponse convertToBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }
}
