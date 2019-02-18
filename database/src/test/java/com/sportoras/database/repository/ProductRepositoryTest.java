//package com.sportoras.database.service;
//
//import com.sportoras.database.config.TestConfiguration;
//import com.sportoras.database.entity.Material;
//import com.sportoras.database.entity.Product;
//import com.sportoras.database.entity.User;
//import com.sportoras.database.util.DatabaseHelper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = TestConfiguration.class)
//@Transactional
//@Rollback
//public class ProductRepositoryTest {
//
//    @Autowired
//    private DatabaseHelper databaseHelper;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Before
//    public void init() {
//        databaseHelper.cleanDatabase();
//        databaseHelper.prepareData();
//    }
//
//    @Test
//    public void checkFindByName() {
//        List<Product> products = productRepository.findByName("Костюм спортивный парадный");
//        System.out.println(products);
//        assertThat(products, hasSize(3));
//    }
//
//    @Test
//    public void checkSave() {
//
//        Material material = new Material("1","1");
//        Product product = Product.builder()
//                .name("Test")
//                .picture("Test")
//                .article("13")
//                .value(BigDecimal.valueOf(14.2))
//                .material(material)
//                .build();
//        productRepository.save(product);
//        Long savedId = product.getId();
//        assertNotNull(savedId);
//    }
//
//    @Test
//    public void checkFindAll() {
//        List<Product> products = productRepository.findAll();
//        assertThat(products, hasSize(4));
//    }
//}