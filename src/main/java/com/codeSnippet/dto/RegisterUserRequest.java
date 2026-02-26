package com.codeSnippet.dto;

import com.codeSnippet.ennum.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    private String userName;
    private String password;
    private Role role;
}
