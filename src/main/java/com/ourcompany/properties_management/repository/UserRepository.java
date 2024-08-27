package com.ourcompany.properties_management.repository;


import com.ourcompany.properties_management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
}
