package com.ourcompany.properties_management.service.impl;

import com.ourcompany.properties_management.convertor.UserConvertor;
import com.ourcompany.properties_management.dto.UserDTO;
import com.ourcompany.properties_management.entity.UserEntity;
import com.ourcompany.properties_management.repository.UserRepository;
import com.ourcompany.properties_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConvertor.convertDTOToEntity(userDTO);

       userEntity =  userRepository.save(userEntity);
      userDTO=  userConvertor.convertEntityToDTO(userEntity);
      return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
