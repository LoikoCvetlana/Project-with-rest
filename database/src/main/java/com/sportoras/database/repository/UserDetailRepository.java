package com.sportoras.database.repository;

import com.sportoras.database.entity.User;
import com.sportoras.database.entity.UserDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDetailRepository extends CrudRepository<UserDetail, Long> {

    List<UserDetail> findAll();

    UserDetail findByUser(User user);

    UserDetail findAllByUserEmail(String email);

}