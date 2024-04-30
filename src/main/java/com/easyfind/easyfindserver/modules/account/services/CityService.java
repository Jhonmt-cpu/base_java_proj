package com.easyfind.easyfindserver.modules.account.services;

import com.easyfind.easyfindserver.modules.account.dtos.CityDTO;
import com.easyfind.easyfindserver.modules.account.dtos.CreateCityDTO;
import com.easyfind.easyfindserver.modules.account.jpa.models.City;
import com.easyfind.easyfindserver.modules.account.jpa.models.State;
import com.easyfind.easyfindserver.modules.account.jpa.repositories.CityRepository;
import com.easyfind.easyfindserver.modules.account.jpa.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;

    public CityDTO createCity(CreateCityDTO createCityDTO) {
        final Optional<State> stateExists = stateRepository.findById(createCityDTO.city_state_id());

        if (stateExists.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "State does not exists");
        }

        final Optional<City> cityAlreadyExist = cityRepository.findByCityNameAndCityStateStateId(
                createCityDTO.city_name(),
                createCityDTO.city_state_id()
        );

        if (cityAlreadyExist.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "City already exists");
        }

        final City city = new City(createCityDTO, stateExists.get());

        final City cityCreated = cityRepository.save(city);

        return cityCreated.toCityDTO();
    };

    public List<CityDTO> listAllCitiesByState(Integer stateId) {
        final List<City> cities = cityRepository.findByCityStateStateId(stateId);

        return cities.stream().map(City::toCityDTO).toList();
    }
}
