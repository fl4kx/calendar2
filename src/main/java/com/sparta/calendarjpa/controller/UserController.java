package com.sparta.calendarjpa.controller;

import com.sparta.calendarjpa.dto.user.CreateUserRequestDto;
import com.sparta.calendarjpa.dto.user.UpdateNameRequestDto;
import com.sparta.calendarjpa.dto.user.UserResponseDto;
import com.sparta.calendarjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> join(@RequestBody CreateUserRequestDto requestDto) {

        UserResponseDto userResponseDto = userService.save(
                requestDto.getName(),
                requestDto.getPassword(),
                requestDto.getPassword()
        );

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Long id, @RequestBody UpdateNameRequestDto requestDto) {

        userService.updateName(id, requestDto.getOldName(), requestDto.getNewName());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        userService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
