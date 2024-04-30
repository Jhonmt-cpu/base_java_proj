package com.easyfind.easyfindserver.modules.account.jpa.repositories;

import com.easyfind.easyfindserver.modules.account.jpa.models.State;
import com.easyfind.easyfindserver.shared.utils.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends BaseRepository<State, Integer> {
    Optional<State> findByStateName(String stateName);
}
