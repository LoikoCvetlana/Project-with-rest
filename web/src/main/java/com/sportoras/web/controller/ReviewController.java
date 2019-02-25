package com.sportoras.web.controller;

import com.sportoras.database.entity.Review;
import com.sportoras.database.entity.User;
import com.sportoras.service.dto.reviewDto.ReviewDto;
import com.sportoras.service.service.ReviewService;
import com.sportoras.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReviewController {

    private final ReviewService reviewService;
    private final UserService userService;

    @GetMapping(value = "/reviews", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<ReviewDto>> listAllReviews() {
        List<ReviewDto> reviews = reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-review/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Void> deleteReview(@PathVariable("id") long id) {
        Optional<Review> review = reviewService.findById(id);
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/review-save", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<ReviewDto> saveReview(@RequestBody ReviewDto reviewDto, Authentication authentication) {
//        User user = userService.findUserByEmail(authentication.getName());
        User user = userService.findUserById(1L);
        reviewDto.setUser(user);
        reviewDto.setDate(LocalDate.now());
        Review review = reviewService.saveReview(reviewDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
