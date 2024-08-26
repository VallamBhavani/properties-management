package com.ourcompany.properties_management.repository;


import com.ourcompany.properties_management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long>{
}
