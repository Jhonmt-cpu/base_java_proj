package com.easyfind.easyfindserver.modules.account.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateStateDTO(
       @NotBlank @Size(min = 3, max = 30) String state_name,
       @NotBlank @Size(min = 2, max = 2) String state_uf
) { }
