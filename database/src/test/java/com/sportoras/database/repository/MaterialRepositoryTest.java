//package com.sportoras.database.service;
//
//import com.sportoras.database.config.TestConfiguration;
//import com.sportoras.database.entity.Material;
//import com.sportoras.database.util.DatabaseHelper;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = TestConfiguration.class)
//@Transactional
//public class MaterialRepositoryTest {
//
//    @Autowired
//    private DatabaseHelper databaseHelper;
//
//    @Autowired
//    private MaterialRepository materialRepository;
//
//    @Before
//    public void init() {
//        databaseHelper.cleanDatabase();
//        databaseHelper.prepareData();
//    }
//
//    @Test
//    public void checkFindByName() {
//        Material material = materialRepository.findByName("Ткань");
//        System.out.println(material);
//        Assert.assertNotNull(material);
//    }
//
//    @Test
//    public void checkSave() {
//        Material material = Material.builder()
//                .name("Meryl")
//                .description("Description")
//                .build();
//        materialRepository.save(material);
//        Long savedId = material.getId();
//        assertNotNull(savedId);
//    }
//
//    @Test
//    public void checkFindAll() {
//        List<Material> materials = materialRepository.findAll();
//        assertThat(materials, hasSize(3));
//    }
//
//    @Test
//    public void checkFindById() {
//        Optional<Material> material = materialRepository.findById(1L);
//        assertNotNull(material);
//    }
//
//    @Test
//    public void testDelite() {
//        Material material = Material.builder()
//                .name("Meryl")
//                .description("Description")
//                .build();
//        materialRepository.save(material);
//        Long savedId = material.getId();
//        materialRepository.findById(savedId);
//        materialRepository.delete(material);
//        Optional<Material> delitMaterial = materialRepository.findById(savedId);
//        assertFalse(delitMaterial.isPresent());
//    }
//}