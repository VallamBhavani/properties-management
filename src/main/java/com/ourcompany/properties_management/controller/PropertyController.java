package com.ourcompany.properties_management.controller;


import com.ourcompany.properties_management.dto.PropertyDTO;
import com.ourcompany.properties_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

   @Autowired
    private PropertyService propertyService;
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello";
    }
    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> save(@RequestBody PropertyDTO propertyDTO)
    {
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity= new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }
 @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties()
    {
        List<PropertyDTO> propertyList= propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId)
    {
       PropertyDTO dto= propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity= new ResponseEntity<>(dto,  HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-desc/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDesc(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId)
    {
        PropertyDTO dto= propertyService.updatePropertyDesc(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity= new ResponseEntity<>(dto, HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId)
    {
        PropertyDTO dto= propertyService. updatePropertyPrice(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity= new ResponseEntity<>(dto,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("/properties/{propertyId}")
    public  ResponseEntity deleteProperty(@PathVariable Long propertyId)
    {
       propertyService.deleteProperty(propertyId);
        ResponseEntity responseEntity= new ResponseEntity<>(null,HttpStatus.OK);
        return  responseEntity;
    }
}
