package com.sportoras.service.service;

import com.sportoras.database.entity.User;
import com.sportoras.database.entity.UserDetail;
import com.sportoras.database.repository.UserDetailRepository;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.dto.userDto.UserDetailCreateDto;
import com.sportoras.service.dto.userDto.UserDetailUpdateDto;
import com.sportoras.service.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailService {

    private final UserDetailRepository userDetailRepository;
    private final UserRepository userRepository;


    @Transactional
    public UserDetail saveUserDetail(UserDetailCreateDto userDetailCreateDto) {
        return userDetailRepository.save(UserDetail.builder()
                .user(userDetailCreateDto.getUser())
                .company(userDetailCreateDto.getCompany())
                .position(userDetailCreateDto.getPosition())
                .phone(userDetailCreateDto.getPhone())
                .otherInformation(userDetailCreateDto.getOtherInformation())
                .build());
    }

    @Transactional
    public UserDetail updarteUserDetail(UserDetailUpdateDto userDetailUpdateDto) {
        Optional.ofNullable(userDetailRepository.findByUser(userDetailUpdateDto.getUser())).orElseThrow(() ->
                new EntityNotFoundException("User detail not found"));
        return userDetailRepository.save(UserDetail.builder()
                .id(userDetailUpdateDto.getId())
                .user(userDetailUpdateDto.getUser())
                .company(userDetailUpdateDto.getCompany())
                .position(userDetailUpdateDto.getPosition())
                .phone(userDetailUpdateDto.getPhone())
                .otherInformation(userDetailUpdateDto.getOtherInformation())
                .build());
    }

    public UserDetail findUserDetailByUser(User user) {
        return userDetailRepository.findByUser(user);
    }

}