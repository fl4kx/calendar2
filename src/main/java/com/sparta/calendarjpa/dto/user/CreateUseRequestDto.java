package com.sparta.calendarjpa.dto.user;

import lombok.Getter;

@Getter
public class CreateUseRequestDto {

    private final String name;

    private final String email;

    private final String password;

    public CreateUseRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
