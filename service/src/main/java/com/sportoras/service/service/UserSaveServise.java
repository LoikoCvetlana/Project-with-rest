package com.sportoras.service.service;

import com.sportoras.database.entity.User;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.dto.userDto.UserCreateDto;
import com.sportoras.service.exception.EntityAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        userRepository.save(User.builder()
                .fullName(userCreateDto.getFullName())
                .email(userCreateDto.getEmail())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .registrationDate(LocalDate.now())
                .role("User")
                .build());

    }
}
