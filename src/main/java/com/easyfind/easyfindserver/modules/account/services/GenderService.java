package com.easyfind.easyfindserver.modules.account.services;

import com.easyfind.easyfindserver.modules.account.jpa.models.Gender;
import com.easyfind.easyfindserver.modules.account.jpa.repositories.GenderRepository;
import com.easyfind.easyfindserver.shared.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GenderService {
    @Autowired
    private GenderRepository genderRepository;

    public Gender createGender(String genderName) {
        var genderAlreadyExists = genderRepository.findByGenderName(genderName);

        if (genderAlreadyExists.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gender Already Exists");
        }

        var gender = new Gender(genderName);

        return genderRepository.save(gender);
    }

    public List<Gender> listAllGenders() {
        return genderRepository.findAll();
    }

    public Page<Gender> listAllGendersPaginated(Pagination pagination) {
        return genderRepository.findAll(
                PageRequest.of(pagination.getPage(), pagination.getSize())
        );
    }
}
