package com.sportoras.service.service;

import com.sportoras.database.entity.Material;
import com.sportoras.database.repository.MaterialRepository;
import com.sportoras.service.dto.Material.MaterialDto;
import com.sportoras.service.exception.BadRequestException;
import com.sportoras.service.exception.EntityAlreadyExistException;
import com.sportoras.service.exception.EntityDidntSaveException;
import com.sportoras.service.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CacheConfig(cacheNames = "materials")
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MaterialService {

    private final MaterialRepository materialRepository;

    public Material findById(Long materialId) {
        Material material = materialRepository.findMaterialById(materialId);
        Optional.ofNullable(material).orElseThrow(() -> new EntityNotFoundException("Material with id " + materialId + " not found."));
        return material;
    }

    public Material findMaterialByName(String name) {
        Material material = materialRepository.findByName(name);
        Optional.ofNullable(material).orElseThrow(() -> new EntityNotFoundException("Material with name " + name + " not found."));
        return material;
    }

    @Cacheable
    public List<MaterialDto> findAllMaterials() {
        return materialRepository.findAll().stream()
                .map(it -> new MaterialDto(it.getId(), it.getName(), it.getDescription()))
                .collect(Collectors.toList());
    }

    @Transactional
    public Material saveMaterial(MaterialDto materialDto) {
        if (materialRepository.findByName(materialDto.getName()) != null) {
            throw new EntityAlreadyExistException("Material already exists");
        }
        if (materialDto.getName() == null || materialDto.getDescription() == null) {
            throw new BadRequestException("The form is filled incorrect.");
        }
        Material material = materialRepository.save(Material.builder()
                .name(materialDto.getName())
                .description(materialDto.getDescription())
                .build());
        if (material == null) {
            throw new EntityDidntSaveException("Material not saved. Try again");
        }
        return material;
    }
}