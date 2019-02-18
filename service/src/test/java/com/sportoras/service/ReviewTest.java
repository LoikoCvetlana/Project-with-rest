package com.sportoras.service;

import com.sportoras.database.entity.*;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.configuration.ServiceConfiguration;
import com.sportoras.service.dto.reviewDto.ReviewDto;
import com.sportoras.service.service.ReviewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class ReviewTest {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkSaveRewiew() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaevna")));
        ReviewDto reviewDto = new ReviewDto(user, "TestRewiew", LocalDate.now());
        Review review = reviewService.saveReview(reviewDto);
        assertNotNull(review);
    }

    @Test
    public void checkAllReview() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaevna")));
        Review review = reviewService.saveReview(new ReviewDto(user, "TestRewiew", LocalDate.now()));
        Review review1 = reviewService.saveReview(new ReviewDto(user, "TestRewiew1", LocalDate.of(2017, 01, 12)));
        Review review2 = reviewService.saveReview(new ReviewDto(user, "TestRewiew2", LocalDate.of(2019, 06, 20)));
        Review review3 = reviewService.saveReview(new ReviewDto(user, "TestRewiew3", LocalDate.now()));
        Review review4 = reviewService.saveReview(new ReviewDto(user, "TestRewiew", LocalDate.now()));
        List<ReviewDto> rewiews = reviewService.findAllReviews();
        assertThat(rewiews, hasSize(5));
    }

    @Test
    public void checkDeleteReview() {
        User user = new User("testmail", "111", FullName.of("Irina", "Nikolaeva"));
        Review review = reviewService.saveReview(new ReviewDto(user, "TestRewiew", LocalDate.now()));
        reviewService.deleteReview(review.getId());
        Review reviewTest= reviewService.findById(review.getId()).orElse(null);
        assertNull(reviewTest);
    }
}
