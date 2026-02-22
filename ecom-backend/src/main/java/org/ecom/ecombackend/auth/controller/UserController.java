package org.ecom.ecombackend.auth.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ecom.ecombackend.auth.dto.UserRequestDto;
import org.ecom.ecombackend.auth.dto.UserResponseDto;
import org.ecom.ecombackend.auth.model.User;
import org.ecom.ecombackend.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto response = userService.createUser(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }
}
