package com.sportoras.service.dto.productDto;

import com.sportoras.database.entity.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateDto {

    private Long id;
    private String name;
    private String article;
    private String picture;
    private BigDecimal value;
    private Material material;

    public ProductCreateDto(String name, String article, String picture, BigDecimal value, Material material) {
        this.name = name;
        this.article = article;
        this.picture = picture;
        this.value = value;
        this.material = material;
    }
}
