package com.ourcompany.properties_management.service;

import com.ourcompany.properties_management.dto.UserDTO;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);

}
