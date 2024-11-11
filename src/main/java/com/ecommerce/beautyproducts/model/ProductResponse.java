package com.ecommerce.beautyproducts.model;

import com.ecommerce.beautyproducts.entity.Brand;
import com.ecommerce.beautyproducts.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse  {
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private String pictureUrl;
    private String productCategory;
    private String productBrand;
}
