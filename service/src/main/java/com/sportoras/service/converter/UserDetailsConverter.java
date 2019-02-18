package com.sportoras.service.converter;

import com.sportoras.database.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsConverter implements Converter<User, UserDetails> {

    @Override
    public UserDetails convert(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
//                .password(passwordEncoder.encode(user.getPassword()))
                .authorities(user.getRole().toString())
                .build();
    }
}