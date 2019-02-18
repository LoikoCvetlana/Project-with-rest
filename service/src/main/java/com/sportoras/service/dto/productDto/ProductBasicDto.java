package com.sportoras.service.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductBasicDto {

    private Long id;
    private String name;
    private String article;
    private String picture;
}
