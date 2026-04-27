package com.example.niokr.controller;

import com.example.niokr.model.Role;
import com.example.niokr.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<String> getAllRoles() {
        return roleService.findAll().stream()
                .map(Role::getName)
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
