package com.easyfind.easyfindserver.modules.account.jpa.repositories;

import com.easyfind.easyfindserver.modules.account.jpa.models.Role;
import com.easyfind.easyfindserver.shared.utils.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
}