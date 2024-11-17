package com.sparta.calendarjpa.controller;

import com.sparta.calendarjpa.dto.user.CreateUseRequestDto;
import com.sparta.calendarjpa.dto.user.UserResponseDto;
import com.sparta.calendarjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> join(@RequestBody CreateUseRequestDto requestDto) {

        UserResponseDto userResponseDto = userService.save(
                requestDto.getName(),
                requestDto.getPassword(),
                requestDto.getPassword()
        );

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);

    }

}
