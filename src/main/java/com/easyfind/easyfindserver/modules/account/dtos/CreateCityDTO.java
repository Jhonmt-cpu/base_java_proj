package com.easyfind.easyfindserver.modules.account.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCityDTO(
        @NotBlank() @Size(min=3, max=60) String city_name,
        @NotNull @Min(1) Integer city_state_id
) { }
