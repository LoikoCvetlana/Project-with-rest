package com.sportoras.database.dto.userDto;

import com.sportoras.database.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailCreateDto {

    private String company;
    private String phone;
    private String otherInformation;
    private String position;
    private User user;
}

