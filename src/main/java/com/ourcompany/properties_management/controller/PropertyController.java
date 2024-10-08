package com.ourcompany.properties_management.controller;


import com.ourcompany.properties_management.dto.PropertyDTO;
import com.ourcompany.properties_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return  new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }
 @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties()
    {
        List<PropertyDTO> propertyList= propertyService.getAllProperties();
        return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }
    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId)
    {
       PropertyDTO dto= propertyService.updateProperty(propertyDTO, propertyId);
        return new ResponseEntity<>(dto,  HttpStatus.OK);
    }
    @PatchMapping("/properties/update-desc/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDesc(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId)
    {
        PropertyDTO dto= propertyService.updatePropertyDesc(propertyDTO, propertyId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId)
    {
        PropertyDTO dto= propertyService. updatePropertyPrice(propertyDTO, propertyId);
         return  new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/properties/{propertyId}")
    public  ResponseEntity deleteProperty(@PathVariable Long propertyId)
    {
       propertyService.deleteProperty(propertyId);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
