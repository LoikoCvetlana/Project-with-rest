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
public class UserBasicDto {

    private Long id;
    private FullName fullName;
    private String Role;
    private UserDetail userDetail;
    private LocalDate registrationDate;
}
