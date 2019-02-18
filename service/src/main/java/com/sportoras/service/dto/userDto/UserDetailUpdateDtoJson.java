package com.sportoras.service.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailUpdateDtoJson {

    private Long id;
    private String company;
    private String phone;
    private String otherInformation;
    private String position;
    private Long userId;
}

