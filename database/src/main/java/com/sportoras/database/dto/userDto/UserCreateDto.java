package com.sportoras.database.dto.userDto;

import com.sportoras.database.entity.FullName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto {

    private Long id;
    private FullName fullName;
    private String password;
    private String email;
    private LocalDate registrationDate;
    private String role;
}
