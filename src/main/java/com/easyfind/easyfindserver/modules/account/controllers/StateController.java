package com.easyfind.easyfindserver.modules.account.controllers;

import com.easyfind.easyfindserver.modules.account.dtos.CreateStateDTO;
import com.easyfind.easyfindserver.modules.account.jpa.models.State;
import com.easyfind.easyfindserver.modules.account.services.StateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @PostMapping
    public ResponseEntity<State> createState(
            @RequestBody @Valid CreateStateDTO createStateDTO
    ) {
        final State state = stateService.createState(createStateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(state);
    }

    @GetMapping("/all")
    public ResponseEntity<List<State>> listAllStates() {
        final List<State> states = stateService.listAllStates();

        return ResponseEntity.status(HttpStatus.OK).body(states);
    }
}
