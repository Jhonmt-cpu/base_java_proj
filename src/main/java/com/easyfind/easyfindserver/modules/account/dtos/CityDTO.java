package com.easyfind.easyfindserver.modules.account.dtos;

import java.time.LocalDateTime;

public record CityDTO(
        Integer cityId,
        String cityName,
        Integer cityStateId,
        LocalDateTime cityCreatedAt
) { }
