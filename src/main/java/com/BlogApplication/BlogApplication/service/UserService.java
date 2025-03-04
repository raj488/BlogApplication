package com.BlogApplication.BlogApplication.service;

import com.BlogApplication.BlogApplication.payload.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto userDto, Integer userID);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);




}
