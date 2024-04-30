package com.easyfind.easyfindserver.modules.account.services;

import com.easyfind.easyfindserver.modules.account.dtos.CreateStateDTO;
import com.easyfind.easyfindserver.modules.account.jpa.models.State;
import com.easyfind.easyfindserver.modules.account.jpa.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public State createState(CreateStateDTO createStateDTO) {
        final Optional<State> stateAlreadyExists = stateRepository.findByStateName(createStateDTO.state_name());

        if (stateAlreadyExists.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "State Already Exists");
        }

        final State state = new State(createStateDTO);

        return stateRepository.save(state);
    }

    public List<State> listAllStates() {
        return stateRepository.findAll();
    }
}
