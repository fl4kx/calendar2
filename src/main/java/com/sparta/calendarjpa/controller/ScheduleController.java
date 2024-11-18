package com.sparta.calendarjpa.controller;

import com.sparta.calendarjpa.dto.schedule.ScheduleDto;
import com.sparta.calendarjpa.service.ScheduleService;
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

import java.util.List;

@Controller
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/{userId}")
    public ResponseEntity<ScheduleDto> save(@PathVariable Long userId, @RequestBody ScheduleDto requestDto) {

        ScheduleDto scheduleDto = scheduleService.save(
                userId,
                requestDto.getTitle(),
                requestDto.getContents()
        );

        return new ResponseEntity<>(scheduleDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleDto>> findAll() {
        List<ScheduleDto> scheduleDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ScheduleDto requestDto) {

        scheduleService.update(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        scheduleService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
