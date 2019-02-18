package com.sportoras.service.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateDtoJson {

    private Long id;
    private String name;
    private String article;
    private String picture;
    private BigDecimal value;
    private Long materialId;

    public ProductCreateDtoJson(String name, String article, String picture, BigDecimal value, Long material) {
        this.name = name;
        this.article = article;
        this.picture = picture;
        this.value = value;
        this.materialId = material;
    }
}
