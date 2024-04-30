package com.easyfind.easyfindserver.modules.account.controllers;

import com.easyfind.easyfindserver.modules.account.dtos.CreateGenderDTO;
import com.easyfind.easyfindserver.modules.account.jpa.models.Gender;
import com.easyfind.easyfindserver.modules.account.services.GenderService;
import com.easyfind.easyfindserver.shared.utils.Pagination;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/gender")
public class GenderController {
    @Autowired
    private GenderService genderService;

    @PostMapping()
    public ResponseEntity<Gender> createGender(
            @RequestBody @Valid CreateGenderDTO createGenderDTO
    ) {
        var gender = genderService.createGender(createGenderDTO.gender_name());

        return ResponseEntity.status(HttpStatus.CREATED).body(gender);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gender>> listAllGenders() {
        var genders = genderService.listAllGenders();

        return ResponseEntity.status(HttpStatus.OK).body(genders);
    }

    @GetMapping()
    public ResponseEntity<Page<Gender>> listAllGendersPaginated(
            @Valid Pagination pagination
    ) {
        var genders = genderService.listAllGendersPaginated(pagination);

        return ResponseEntity.status(HttpStatus.OK).body(genders);
    }
}
