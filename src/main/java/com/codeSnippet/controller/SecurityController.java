package com.codeSnippet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping("/health")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Application is healthy", HttpStatus.OK);
    }

    @PostMapping("/health")
    @PreAuthorize("hasAuthority('WRITE')")
    public ResponseEntity<String> healthCheckPost(@RequestBody String body) {
        return new ResponseEntity<>(body + " received", HttpStatus.OK);
    }
}
