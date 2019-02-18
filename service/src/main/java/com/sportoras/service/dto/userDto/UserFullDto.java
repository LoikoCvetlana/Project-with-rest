package com.sportoras.service.dto.userDto;

import com.sportoras.database.entity.FullName;
import com.sportoras.database.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFullDto {

    private Long id;
    private FullName fullName;
    private String password;
    private String email;
    private UserDetail userDetail;
    private LocalDate registrationDate;
    private String company;
    private String position;
}
