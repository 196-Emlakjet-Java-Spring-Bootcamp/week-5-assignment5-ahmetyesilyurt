package com.ysl.rabbitmq.service;

import com.ysl.rabbitmq.dto.UserDto;
import com.ysl.rabbitmq.model.User;

import java.util.List;

public interface UserService {
    void createUser(UserDto userDto);
    List<User> getAllUser();


}
