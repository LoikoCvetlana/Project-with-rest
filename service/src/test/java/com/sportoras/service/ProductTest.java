package com.sportoras.service;

import com.sportoras.database.entity.Material;
import com.sportoras.database.entity.Product;
import com.sportoras.service.configuration.ServiceConfiguration;
import com.sportoras.service.dto.Material.MaterialDto;
import com.sportoras.service.dto.productDto.ProductBasicDto;
import com.sportoras.service.dto.productDto.ProductCreateDto;
import com.sportoras.service.exception.EntityAlreadyExistException;
import com.sportoras.service.exception.EntityNotFoundException;
import com.sportoras.service.service.MaterialService;
import com.sportoras.service.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class ProductTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private MaterialService materialService;

    @Test
    public void checkSaveProduct() {
        Material material = materialService.saveMaterial(new MaterialDto("Test Material", "Test description"));
        ProductCreateDto productCreateDto = new ProductCreateDto
                ("TstsProduct","KP1","/KP1", BigDecimal.valueOf(100.24),material);
        Product product = productService.saveProduct(productCreateDto);
        assertNotNull(product);
    }

    @Test
    public void checkAllProducts() {
        Material material = materialService.saveMaterial(new MaterialDto("Test Material", "Test description"));
        Product product = productService.saveProduct(new ProductCreateDto
                ("TstsProduct","KP1","/KP1", BigDecimal.valueOf(100.24),material));
        Product product1 = productService.saveProduct(new ProductCreateDto
                ("TstsProduct2","KP2","/KP2", BigDecimal.valueOf(144.00),material));
        Product product2 = productService.saveProduct(new ProductCreateDto
                ("TstsProduct3","KP3","/KP3", BigDecimal.valueOf(60.00),material));
        List<ProductBasicDto> products = productService.findAllProducts();
        assertThat(products, hasSize(3));
    }

    @Test
    public void checkFindById() {
        Material material = materialService.saveMaterial(new MaterialDto("Test Material", "Test description"));
        Product product = productService.saveProduct(new ProductCreateDto
                ("TstsProduct","KP1","/KP1", BigDecimal.valueOf(100.24),material));
        Product productTest = productService.findProductById(product.getId());
        assertNotNull(productTest);
    }

    @Test(expected = EntityAlreadyExistException.class)
    public void checkSaveExceptin() {
        Material material = materialService.saveMaterial(new MaterialDto("Test Material", "Test description"));
        ProductCreateDto productCreateDto = new ProductCreateDto
                ("TstsProduct","KP1","/KP1", BigDecimal.valueOf(100.24),material);
        Product product = productService.saveProduct(productCreateDto);
        Product product2 = productService.saveProduct(productCreateDto);

    }

    @Test(expected = EntityNotFoundException.class)
    public void checkFindByIdExceptin() {
        Product product = productService.findProductById(100L);
    }
}
