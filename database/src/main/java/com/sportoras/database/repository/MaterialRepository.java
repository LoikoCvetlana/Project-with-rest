package com.sportoras.database.repository;

import com.sportoras.database.entity.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MaterialRepository extends CrudRepository<Material, Long> {

    List<Material> findAll();

    Material findByName(String name);

    Material findMaterialById(Long id);

}