package com.codeSnippet.dto;

import com.codeSnippet.ennum.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String userName;
    private Role role;
}
