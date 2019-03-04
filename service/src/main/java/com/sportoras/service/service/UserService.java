package com.sportoras.service.service;

import com.sportoras.database.entity.User;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.dto.userDto.UserBasicDto;
import com.sportoras.service.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    public User findUserById(Long userId) {
        User user = userRepository.findUserById(userId);
        Optional.ofNullable(user).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found."));
        return user;
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;
    }

    public List<UserBasicDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(it -> new UserBasicDto(it.getId(), it.getFullName(), it.getRole(), it.getUserDetail(), it.getRegistrationDate()))
                .collect(Collectors.toList());
    }
}