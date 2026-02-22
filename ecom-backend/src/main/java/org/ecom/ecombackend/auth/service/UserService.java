package org.ecom.ecombackend.auth.service;

import org.ecom.ecombackend.auth.dto.UserRequestDto;
import org.ecom.ecombackend.auth.dto.UserResponseDto;
import org.ecom.ecombackend.auth.model.User;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto requestDto);
    List<User> getAllUsers();
}
