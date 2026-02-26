package com.codeSnippet.controller;

import com.codeSnippet.dto.RegisterUserRequest;
import com.codeSnippet.dto.UserResponse;
import com.codeSnippet.ennum.Role;
import com.codeSnippet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        registerUserRequest.setRole(Role.USER);
        return new ResponseEntity<>(userService.registerUser(registerUserRequest), HttpStatus.CREATED);
    }

    @PostMapping("/admin/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> registerAdmin(@RequestBody RegisterUserRequest registerUserRequest) {
        return new ResponseEntity<>(userService.registerUser(registerUserRequest), HttpStatus.CREATED);
    }
}
