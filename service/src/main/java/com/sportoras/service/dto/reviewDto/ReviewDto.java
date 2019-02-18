package com.sportoras.service.dto.reviewDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sportoras.database.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {

    private Long id;
    private User user;
    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    public ReviewDto(User user, String text, LocalDate date) {
        this.user = user;
        this.text = text;
        this.date = date;
    }
}
