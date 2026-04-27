package com.example.niokr.service;

import com.example.niokr.model.Role;
import com.example.niokr.model.RoleName;
import com.example.niokr.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
