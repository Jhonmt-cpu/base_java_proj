package com.easyfind.easyfindserver.modules.account.controllers;

import com.easyfind.easyfindserver.modules.account.dtos.CreateRoleDTO;
import com.easyfind.easyfindserver.modules.account.jpa.models.Role;
import com.easyfind.easyfindserver.modules.account.services.RoleService;
import com.easyfind.easyfindserver.shared.utils.Pagination;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping()
    public ResponseEntity<Role> createRole(
            @RequestBody @Valid CreateRoleDTO createRoleDTO
    ) {
        final Role role = roleService.createRole(createRoleDTO.role_name());

        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    @GetMapping()
    public ResponseEntity<Page<Role>> listAllRolesPaginated(
            @Valid Pagination pagination
    ) {
        final Page<Role> roles = roleService.listAllRolesPaginated(pagination);

        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }
}
