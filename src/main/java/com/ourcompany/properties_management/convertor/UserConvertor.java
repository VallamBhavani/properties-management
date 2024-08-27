package com.ourcompany.properties_management.convertor;

import com.ourcompany.properties_management.dto.UserDTO;
import com.ourcompany.properties_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    public UserEntity convertDTOToEntity(UserDTO userDTO)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhone(userDTO.getPhone());
        return  userEntity;
    }
    public UserDTO convertEntityToDTO(UserEntity userEntity)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhone(userEntity.getPhone());
        return  userDTO;
    }
}
