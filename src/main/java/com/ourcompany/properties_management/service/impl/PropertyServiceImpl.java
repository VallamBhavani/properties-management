package com.ourcompany.properties_management.service.impl;


import com.ourcompany.properties_management.convertor.PropertyConvertor;
import com.ourcompany.properties_management.dto.PropertyDTO;
import com.ourcompany.properties_management.entity.PropertyEntity;
import com.ourcompany.properties_management.repository.PropertyRepository;
import com.ourcompany.properties_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConvertor propertyConvertor;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe=propertyConvertor.convertDTOtoEntity(propertyDTO);
        pe= propertyRepository.save(pe);

        propertyDTO = propertyConvertor.convertEntityToDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        System.out.println("Display all properties");
        List<PropertyEntity> listOfProps = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propsList= new ArrayList<>();
        for(PropertyEntity entity:listOfProps)
        {
          PropertyDTO dto=  propertyConvertor.convertEntityToDTO(entity);
            propsList.add(dto);
        }
        return propsList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity>  optn= propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optn.isPresent())
        {
            PropertyEntity pe = optn.get();// Data from database
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
           dto= propertyConvertor.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDesc(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity>  optn= propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optn.isPresent())
        {
            PropertyEntity pe = optn.get();// Data from database
            pe.setDescription(propertyDTO.getDescription());
            dto= propertyConvertor.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity>  optn= propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optn.isPresent())
        {
            PropertyEntity pe = optn.get();// Data from database
            pe. setPrice(propertyDTO.getPrice());
            dto= propertyConvertor.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
