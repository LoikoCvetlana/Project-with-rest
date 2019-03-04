package com.sportoras.web.controller;

import com.sportoras.database.entity.Material;
import com.sportoras.service.dto.Material.MaterialDto;
import com.sportoras.service.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MaterialController {

    private final MaterialService materialService;


//    @ApiOperation(value = "Returns test details")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful retrieval", response = MaterialController.class),
//            @ApiResponse(code = 404, message = "Test does not exist"),
//            @ApiResponse(code = 500, message = "Internal server error")}
//    )
    @GetMapping(value = "/materials", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<MaterialDto>> listAllMaterials() {
        return new ResponseEntity<>(materialService.findAllMaterials(), HttpStatus.OK);
    }

    @PostMapping(value = "/material-save", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Void> saveMaterial(@RequestBody MaterialDto materialDto) {
        materialService.saveMaterial(materialDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/material-info/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Material> getMaterialById(@PathVariable("id") long id) {
        return new ResponseEntity<>(materialService.findById(id), HttpStatus.OK);
    }
}
