package com.sparta.calendarjpa.service;

import com.sparta.calendarjpa.dto.user.UserResponseDto;
import com.sparta.calendarjpa.entity.User;
import com.sparta.calendarjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto save(String name, String password, String email) {

        User user = new User(name, password, email);

        User savedUser = userRepository.save(user);


        return new UserResponseDto(savedUser.getName(), savedUser.getEmail());

    }



}
