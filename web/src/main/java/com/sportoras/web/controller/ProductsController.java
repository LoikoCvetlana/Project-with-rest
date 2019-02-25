package com.sportoras.web.controller;

import com.sportoras.database.entity.Material;
import com.sportoras.database.entity.Product;
import com.sportoras.service.dto.productDto.ProductBasicDto;
import com.sportoras.service.dto.productDto.ProductCreateDto;
import com.sportoras.service.dto.productDto.ProductCreateDtoJson;
import com.sportoras.service.service.MaterialService;
import com.sportoras.service.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class ProductsController {

    ProductService productService;
    MaterialService materialService;

    @GetMapping(value = "/products", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<ProductBasicDto>> listAllProducts() {
        List<ProductBasicDto> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/products-by-material/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<ProductBasicDto>> listAllProductsByMaterial(@PathVariable("id") long id) {
        List<ProductBasicDto> products = productService.findProductByMaterial(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value = "/product-save", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<ProductCreateDto> saveProduct(@RequestBody ProductCreateDtoJson productCreateDtoJson) {
        Material material = materialService.findById(productCreateDtoJson.getMaterialId());
        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                .material(material)
                .article(productCreateDtoJson.getArticle())
                .name(productCreateDtoJson.getName())
                .picture(productCreateDtoJson.getPicture())
                .value(productCreateDtoJson.getValue())
                .build();
        productService.saveProduct(productCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/product-info/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
