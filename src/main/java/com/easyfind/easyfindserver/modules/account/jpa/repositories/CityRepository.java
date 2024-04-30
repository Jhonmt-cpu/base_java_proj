package com.easyfind.easyfindserver.modules.account.jpa.repositories;

import com.easyfind.easyfindserver.modules.account.jpa.models.City;
import com.easyfind.easyfindserver.shared.utils.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends BaseRepository<City, Integer> {
    Optional<City> findByCityNameAndCityStateStateId(String cityName, Integer cityStateId);
    List<City> findByCityStateStateId(Integer cityStateId);
}
