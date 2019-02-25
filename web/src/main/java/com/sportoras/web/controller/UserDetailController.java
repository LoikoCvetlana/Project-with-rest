package com.sportoras.web.controller;

import com.sportoras.database.entity.User;
import com.sportoras.database.entity.UserDetail;
import com.sportoras.service.dto.userDto.UserDetailCreateDto;
import com.sportoras.service.dto.userDto.UserDetailUpdateDto;
import com.sportoras.service.dto.userDto.UserDetailUpdateDtoJson;
import com.sportoras.service.service.UserDetailService;
import com.sportoras.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SessionAttributes(value = "user")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailController {

    private final UserDetailService userDetailService;
    private final UserService userService;

    @PostMapping(value = "/detail-save", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Void> saveUserDetail(@RequestBody UserDetailCreateDto userDetailCreateDto) {
        //        User user = userService.findUserByEmail(authentication.getName());
        User user = userService.findUserById(11L);
        userDetailCreateDto.setUser(user);
        userDetailService.saveUserDetail(userDetailCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/change-user-detail", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<UserDetail> changeUserDetail(@RequestBody UserDetailUpdateDtoJson userDetailUpdateDtoJson) {
//        User user = userService.findUserById(userDetailUpdateDtoJson.getUserId());
        User user = userService.findUserById(11L);
        UserDetailUpdateDto userDetailUpdateDto = UserDetailUpdateDto.builder()
                .company(userDetailUpdateDtoJson.getCompany())
                .id(userDetailService.findUserDetailByUser(user).getId())
                .otherInformation(userDetailUpdateDtoJson.getOtherInformation())
                .phone(userDetailUpdateDtoJson.getPhone())
                .position(userDetailUpdateDtoJson.getPosition())
                .user(user)
                .build();
        UserDetail userDetail = userDetailService.updarteUserDetail(userDetailUpdateDto);
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }
}
