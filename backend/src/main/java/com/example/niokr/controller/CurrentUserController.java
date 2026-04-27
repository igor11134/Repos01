package com.example.niokr.controller;

import com.example.niokr.dto.UserDto;
import com.example.niokr.model.Role;
import com.example.niokr.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class CurrentUserController {

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null || !(auth.getPrincipal() instanceof User user)) {
            return ResponseEntity.status(401).build();
        }

        UserDto dto = new UserDto(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getRoles().stream().map(Role::getName).map(Enum::name).collect(Collectors.toSet())
        );

        return ResponseEntity.ok(dto);
    }
}
