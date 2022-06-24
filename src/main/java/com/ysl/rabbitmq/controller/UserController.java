package com.ysl.rabbitmq.controller;

import com.ysl.rabbitmq.dto.UserDto;
import com.ysl.rabbitmq.model.User;
import com.ysl.rabbitmq.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String createUser(UserDto userDto) {
        userService.createUser(userDto);
        return "İşleminiz başarıyla alınmıştır!";
    }

    @GetMapping("/users")
    public List<User> getAllSaleAdvertisements() {
        return userService.getAllUser();
    }
}
