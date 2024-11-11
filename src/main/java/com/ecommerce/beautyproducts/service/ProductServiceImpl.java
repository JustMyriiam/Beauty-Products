package com.ecommerce.beautyproducts.service;

import com.ecommerce.beautyproducts.entity.Product;
import com.ecommerce.beautyproducts.model.ProductResponse;
import com.ecommerce.beautyproducts.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse getProductById(Integer productId) {
        log.info("Fetching Product by Id {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with given id doesn't exist"));
        // convert the product to product response
        ProductResponse productResponse = convertToProductResponse(product);
        log.info("Fetched Product by Id {}", productId);
        return productResponse ;
    }

    @Override
    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        log.info("Fetching all products");
        Page<Product> productPage = productRepository.findAll(pageable);
        // map
        Page<ProductResponse> productResponsePage = productPage
                .map(this::convertToProductResponse);
        log.info("Fetched all products");
        return productResponsePage;
    }

    @Override
    public List<ProductResponse> searchProductsByName(String keyword) {
        log.info("Searching products by name {}", keyword);
        // custom query
        List<Product> productList = productRepository.searchByName(keyword);
        List<ProductResponse> productResponseList = productList.stream()
                .map(this::convertToProductResponse)
                .collect(Collectors.toList());
        return productResponseList;
    }

    private ProductResponse convertToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .pictureUrl(product.getPictureUrl())
                .productCategory(product.getCategory().getName())
                .productBrand(product.getBrand().getName())
                .build();
    }
}
