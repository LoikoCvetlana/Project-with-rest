package com.sportoras.database.repository;

import com.sportoras.database.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByUserEmail(String email);

    List<Review> findAll();

    void deleteById(Long id);

    Optional<Review> findById (Long id);

}