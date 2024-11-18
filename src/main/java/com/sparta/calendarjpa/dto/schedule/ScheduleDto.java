package com.sparta.calendarjpa.dto.schedule;

import com.sparta.calendarjpa.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleDto {

    private final String title;

    private final String contents;

    public ScheduleDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleDto toDto(Schedule schedule) {
        return new ScheduleDto(schedule.getTitle(), schedule.getContents());
    }

}
