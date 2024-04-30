package com.easyfind.easyfindserver.modules.account.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateRoleDTO (
        @NotBlank @Size(min=3, max=30) String role_name
) { }
