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
public class ProductFullDto {

    private Long id;
    private String name;
    private String article;
    private String picture;
    private BigDecimal value;
    private Material material;
}