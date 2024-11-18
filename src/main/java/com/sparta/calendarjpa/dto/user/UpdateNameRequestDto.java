package com.sparta.calendarjpa.dto.user;

import lombok.Getter;

@Getter
public class UpdateNameRequestDto {
    private final String oldName;

    private final String newName;

    public UpdateNameRequestDto(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }
}
