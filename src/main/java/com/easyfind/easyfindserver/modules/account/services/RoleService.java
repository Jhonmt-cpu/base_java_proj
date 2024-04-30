package com.easyfind.easyfindserver.modules.account.services;

import com.easyfind.easyfindserver.modules.account.jpa.models.Role;
import com.easyfind.easyfindserver.modules.account.jpa.repositories.RoleRepository;
import com.easyfind.easyfindserver.shared.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(String roleName) {
        final Optional<Role> roleAlreadyExists = roleRepository.findByRoleName(roleName);

        if (roleAlreadyExists.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role Already Exists");
        }

        final Role role = new Role(roleName);

        return roleRepository.save(role);
    }

    public Page<Role> listAllRolesPaginated(Pagination pagination) {
        return roleRepository.findAll(
                PageRequest.of(pagination.getPage(), pagination.getSize())
        );
    }
}
