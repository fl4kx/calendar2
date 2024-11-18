package com.sparta.calendarjpa.service;

import com.sparta.calendarjpa.dto.user.UserResponseDto;
import com.sparta.calendarjpa.entity.User;
import com.sparta.calendarjpa.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto save(String name, String password, String email) {

        User user = new User(name, password, email);

        User savedUser = userRepository.save(user);


        return new UserResponseDto(savedUser.getName(), savedUser.getEmail());

    }


    public UserResponseDto findById(Long id) {
        User finduser = userRepository.findByIdOrElseThrow(id);

        return new UserResponseDto(finduser.getName(), finduser.getEmail());
    }

    @Transactional
    public void updateName(Long id, String oldName, String newName) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getName().equals(oldName)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        findUser.updateName(newName);
    }

    public void deleteById(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }
}
