package com.sportoras.service.service;

import com.sportoras.database.entity.Review;
import com.sportoras.database.repository.ReviewRepository;
import com.sportoras.service.dto.reviewDto.ReviewDto;
import com.sportoras.service.exception.BadRequestException;
import com.sportoras.service.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewDto> findAllReviews() {
        return reviewRepository.findAll().stream()
                .map(it -> new ReviewDto(it.getId(), it.getUser(), it.getText(), it.getDate()))
                .collect(Collectors.toList());
    }

    @Transactional
    public Review saveReview(ReviewDto reviewDto) {
        Review review = reviewRepository.save(Review.builder()
                .user(reviewDto.getUser())
                .date(LocalDate.now())
                .text(reviewDto.getText())
                .build());
        if (review.getText() == null) {
            throw new BadRequestException("The form is filled incorrect.");
        }
        return review;

    }

    @Transactional
    public void deleteReview(Long reviewId) {
        reviewRepository.findById(reviewId).orElseThrow(() ->
                new EntityNotFoundException("Review with id " + reviewId + " not found."));
        reviewRepository.deleteById(reviewId);
    }

    public Optional<Review> findById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

}