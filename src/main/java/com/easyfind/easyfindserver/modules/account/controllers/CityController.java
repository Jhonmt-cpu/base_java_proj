package com.easyfind.easyfindserver.modules.account.controllers;

import com.easyfind.easyfindserver.modules.account.dtos.CityDTO;
import com.easyfind.easyfindserver.modules.account.dtos.CreateCityDTO;
import com.easyfind.easyfindserver.modules.account.services.CityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityDTO> createCity(
            @RequestBody @Valid CreateCityDTO createCityDTO
    ) {
        final CityDTO city = cityService.createCity(createCityDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(city);
    }

    @GetMapping("/state/{stateId}")
    public ResponseEntity<List<CityDTO>> listAllByState(
            @PathVariable @NotNull @Min(1) Integer stateId
    ) {
        final List<CityDTO> cities = cityService.listAllCitiesByState(stateId);

        return ResponseEntity.status(200).body(cities);
    }
}
