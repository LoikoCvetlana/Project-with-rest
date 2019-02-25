package com.sportoras.service.service;

import com.sportoras.database.entity.User;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.dto.userDto.UserCreateDto;
import com.sportoras.service.exception.BadRequestException;
import com.sportoras.service.exception.EntityAlreadyExistException;
import com.sportoras.service.exception.EntityDidntSaveException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserSaveServise {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveNewUser(UserCreateDto userCreateDto) {
        if (userRepository.findByEmail(userCreateDto.getEmail()).isPresent()) {
            throw new EntityAlreadyExistException("User already exists");
        }
        if (userCreateDto.getEmail() == null || userCreateDto.getPassword() == null) {
            throw new BadRequestException("The form is filled incorrect. Enter the email and password in form.");
        }
        User user = userRepository.save(User.builder()
                .fullName(userCreateDto.getFullName())
                .email(userCreateDto.getEmail())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .registrationDate(LocalDate.now())
                .role("User")
                .build());

        if (user == null) {
            throw new EntityDidntSaveException("User not saved. Try again");
        }

    }
}
