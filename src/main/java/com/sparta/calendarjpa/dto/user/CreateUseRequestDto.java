package com.sparta.calendarjpa.dto.user;

import lombok.Getter;

@Getter
public class CreateUserDto {

    private final String username;

    private final String email;

    private final String password;

    public CreateUserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
