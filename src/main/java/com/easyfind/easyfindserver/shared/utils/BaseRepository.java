package com.easyfind.easyfindserver.shared.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<Type, ID extends Serializable> extends Repository<Type, ID> {
    Type save(Type type);
    Optional<Type> findById(ID id);
    List<Type> findAll();
    Page<Type> findAll(Pageable pageable);
    void delete(Type type);
}
