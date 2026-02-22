package org.ecom.ecombackend.auth.service.impl;

import org.ecom.ecombackend.auth.dto.UserRequestDto;
import org.ecom.ecombackend.auth.dto.UserResponseDto;
import org.ecom.ecombackend.auth.model.User;
import org.ecom.ecombackend.auth.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserRequestDto requestDto;
    private User savedUser;

    @BeforeEach
    void setUp() {
        requestDto = UserRequestDto.builder()
                .fullName("Venkatesh")
                .email("venky@test.com")
                .password("password123")
                .build();

        savedUser = User.builder()
                .id(UUID.randomUUID())
                .fullName("Venkatesh")
                .email("venky@test.com")
                .password("password123")
                .build();
    }

    @Test
    void createUser_ShouldReturnUserResponseDto_WhenUserIsSavedSuccessfully() {

        // Arrange
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        UserResponseDto response = userService.createUser(requestDto);

        // Assert
        assertNotNull(response);
        assertEquals(savedUser.getId(), response.getId());
        assertEquals("Venkatesh", response.getFullName());
        assertEquals("venky@test.com", response.getEmail());
        assertEquals("password123", response.getPassword());

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void createUser_ShouldCallRepositorySave() {

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        userService.createUser(requestDto);

        verify(userRepository).save(any(User.class));
    }

    @Test
    void createUser_ShouldMapRequestToUserCorrectly() {

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        userService.createUser(requestDto);

        verify(userRepository).save(argThat(user ->
                user.getFullName().equals("Venkatesh") &&
                        user.getEmail().equals("venky@test.com") &&
                        user.getPassword().equals("password123")
        ));
    }
}