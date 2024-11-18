package com.sparta.calendarjpa.service;

import com.sparta.calendarjpa.dto.schedule.ScheduleDto;
import com.sparta.calendarjpa.entity.Schedule;
import com.sparta.calendarjpa.entity.User;
import com.sparta.calendarjpa.repository.ScheduleRepository;
import com.sparta.calendarjpa.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;

    private final ScheduleRepository scheduleRepository;

    public ScheduleDto save(Long userId, String title, String contents) {

        User findUser = userRepository.findByIdOrElseThrow(userId);

        Schedule schedule = new Schedule(title, contents);

        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);


        return new ScheduleDto(savedSchedule.getTitle(), savedSchedule.getContents());
    }

    public List<ScheduleDto> findAll() {
        return scheduleRepository.findAll().stream().map(ScheduleDto::toDto).toList();
    }

    @Transactional
    public void update(Long id, String title, String contents) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        schedule.update(title, contents);

    }

    public void deleteById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
