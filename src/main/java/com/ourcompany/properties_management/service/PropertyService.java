package com.ourcompany.properties_management.service;


import com.ourcompany.properties_management.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

     PropertyDTO saveProperty(PropertyDTO propertyDTO);
      List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
     PropertyDTO updatePropertyDesc(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
    void deleteProperty(Long propertyId);




}
