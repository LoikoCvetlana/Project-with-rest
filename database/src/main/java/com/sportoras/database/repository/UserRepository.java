package com.sportoras.database.repository;

import com.sportoras.database.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByEmail(String email);

    List<User> findAllByUserDetailCompany(String compony);

    User findUserById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

}