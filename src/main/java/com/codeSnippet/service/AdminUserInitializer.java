package com.codeSnippet.service;

import com.codeSnippet.ennum.Role;
import com.codeSnippet.entity.Users;
import com.codeSnippet.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitializer {
    @Bean
    public CommandLineRunner createAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUserName("admin").isEmpty()) {
                Users admin = new Users();
                admin.setUserName("admin");
                admin.setPassword(passwordEncoder.encode("admin1234"));
                admin.setRole(Role.ADMIN);

                userRepository.save(admin);
                System.out.println("Default admin user Created");
            }
            if (userRepository.findByUserName("user").isEmpty()) {
                Users user = new Users();
                user.setUserName("user");
                user.setPassword(passwordEncoder.encode("user1234"));
                user.setRole(Role.USER);

                userRepository.save(user);
                System.out.println("Default user Created");
            }
        };
    }
}
