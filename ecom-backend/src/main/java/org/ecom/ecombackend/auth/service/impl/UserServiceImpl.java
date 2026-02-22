package org.ecom.ecombackend.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.ecom.ecombackend.auth.dto.UserRequestDto;
import org.ecom.ecombackend.auth.dto.UserResponseDto;
import org.ecom.ecombackend.auth.model.User;
import org.ecom.ecombackend.auth.repositories.UserRepository;
import org.ecom.ecombackend.auth.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto request) {
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponseDto.builder()
                .id(savedUser.getId())
                .fullName(savedUser.getFullName())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .build();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
