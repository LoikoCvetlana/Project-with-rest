package com.sportoras.web.controller;

import com.sportoras.database.entity.User;
import com.sportoras.service.dto.userDto.UserBasicDto;
import com.sportoras.service.dto.userDto.UserCreateDto;
import com.sportoras.service.exception.EntityNotFoundException;
import com.sportoras.service.service.UserSaveServise;
import com.sportoras.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;

@SessionAttributes(value = "user")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;
    private final UserSaveServise userSaveServise;
    private Logger LOGGER = LogManager.getLogger(UserController.class);

    @GetMapping(value = "/users", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<UserBasicDto>> listAllUsers() {
        List<UserBasicDto> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/user-info/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<User> getProductById(@PathVariable("id") long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/user-save",  consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Void> saveProduct(@RequestBody UserCreateDto userCreateDto) {
        userSaveServise.saveNewUser(userCreateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
