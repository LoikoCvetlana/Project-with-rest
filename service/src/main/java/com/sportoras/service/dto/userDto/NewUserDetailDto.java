package com.sportoras.service.dto.userDto;

import com.sportoras.database.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewUserDetailDto {

    private Long id;
    private String company = null;
    private String phone = null;
    private String otherInformation = null;
    private String position = null;
    private User user;
}

