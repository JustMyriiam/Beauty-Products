package com.ecommerce.beautyproducts.controller;

import com.ecommerce.beautyproducts.model.BrandResponse;
import com.ecommerce.beautyproducts.model.CategoryResponse;
import com.ecommerce.beautyproducts.model.ProductResponse;
import com.ecommerce.beautyproducts.service.BrandService;
import com.ecommerce.beautyproducts.service.CategoryService;
import com.ecommerce.beautyproducts.service.ProductService;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final BrandService brandService;

    public ProductController(ProductService productService, CategoryService categoryService, BrandService brandService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Integer productId) {
        ProductResponse productResponse = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<ProductResponse>> getAllProducts(
            @PageableDefault(size = 10)Pageable pageable,
            @RequestParam(name = "keyword", required=false) String keyword,
            @RequestParam(name = "sort", defaultValue = "name") String sort,
            @RequestParam(name = "order", defaultValue = "asc") String order
    ){
        Page<ProductResponse> productResponsePage;
        if(keyword!=null && !keyword.isEmpty()){
            List<ProductResponse> productResponseList = productService.searchProductsByName(keyword);
            productResponsePage = new PageImpl<>(productResponseList, pageable, productResponseList.size());
        } else {
            // no search criteria => sort
            Sort.Direction direction = "asc".equalsIgnoreCase(order) ? Sort.Direction.ASC : Sort.Direction.DESC;
            Sort sorting = Sort.by(direction, sort);
            productResponsePage = productService.getAllProducts(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sorting));
        }
        return new ResponseEntity<>(productResponsePage, HttpStatus.OK);
    }

    @GetMapping("/brands")
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        List<BrandResponse> brandResponseList = brandService.getAllBrands();
        return new ResponseEntity<>(brandResponseList, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categoryResponseList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponseList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProducts(@RequestParam("keyword") String keyword) {
        List<ProductResponse> productResponseList = productService.searchProductsByName(keyword);
        return new ResponseEntity<>(productResponseList, HttpStatus.OK);
    }
}
