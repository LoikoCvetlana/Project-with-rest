package com.sportoras.service.dto.Material;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class MaterialDto {

    private Long id;
    private String name;
    private String description;


    public MaterialDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public MaterialDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}