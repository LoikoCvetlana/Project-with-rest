package com.sportoras.service;

import com.sportoras.database.entity.Material;
import com.sportoras.service.configuration.ServiceConfiguration;
import com.sportoras.service.dto.Material.MaterialDto;
import com.sportoras.service.service.MaterialService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class MaterialTest {

    @Autowired
    private MaterialService materialService;

    @Test
    public void checkSaveMaterial() {
        Material material = materialService.saveMaterial(new MaterialDto("Test Material", "Test description"));
        assertNotNull(material);
    }

    @Test
    public void checkAllMaterials() {
        Material material = materialService.saveMaterial(new MaterialDto("Test Material", "Test description"));
        Material material1 = materialService.saveMaterial(new MaterialDto("Test Material 2", "Test description 2"));
        List<MaterialDto> materials = materialService.findAllMaterials();
        assertThat(materials, hasSize(2));
    }

    @Test
    public void checkFindById() {
        Material material = materialService.saveMaterial(new MaterialDto("Test Material", "Test description"));
        Material materialTest = materialService.findById(material.getId());
        assertNotNull(materialTest);
    }
}
