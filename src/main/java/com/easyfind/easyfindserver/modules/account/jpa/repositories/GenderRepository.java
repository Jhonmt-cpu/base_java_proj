package com.easyfind.easyfindserver.modules.account.jpa.repositories;

import com.easyfind.easyfindserver.modules.account.jpa.models.Gender;
import com.easyfind.easyfindserver.shared.utils.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository extends BaseRepository<Gender, Integer> {
    Optional<Gender> findByGenderName(String gender_name);
}
