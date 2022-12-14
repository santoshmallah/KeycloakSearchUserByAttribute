package com.main.santosh.mappers;

import org.keycloak.models.UserModel;

import com.main.santosh.models.UserDto;

public class UserMapper {
    
    public  UserDto mapToUserDto(UserModel um,String prm) {
        return new UserDto(
            um.getUsername(),
            um.getFirstName(),
            um.getLastName(),
            um.getId(),
            um.getEmail(),
            um.getAttribute(prm).get(0)
            );

    }
}
