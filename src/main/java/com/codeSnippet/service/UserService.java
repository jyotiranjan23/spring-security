package com.codeSnippet.service;

import com.codeSnippet.dto.RegisterUserRequest;
import com.codeSnippet.dto.UserResponse;
import com.codeSnippet.entity.Users;
import com.codeSnippet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse registerUser(RegisterUserRequest registerUserRequest) {
        //TODO check if user already present
        if (userRepository.findByUserName(registerUserRequest.getUserName()).isPresent()) {
            throw new RuntimeException("User already present");
        }
        //TODO encode password
        //TODO save user to database
        Users user = new Users();
        user.setUserName(registerUserRequest.getUserName());
        user.setRole(registerUserRequest.getRole());
        user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        Users savedUser = userRepository.save(user);
        return mapToUserResponse(savedUser);
    }
    private UserResponse mapToUserResponse(Users user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(user.getUsername());
        userResponse.setRole(user.getRole());
        return userResponse;
    }

}
