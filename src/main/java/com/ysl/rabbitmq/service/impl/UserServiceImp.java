package com.ysl.rabbitmq.service.impl;

import com.ysl.rabbitmq.dao.UserRepo;
import com.ysl.rabbitmq.dto.UserDto;
import com.ysl.rabbitmq.model.User;
import com.ysl.rabbitmq.service.UserService;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;
    private final DirectExchange exchange;
    private final RabbitTemplate rabbitTemplate;

    @Value("${sample.rabbitmq.routingKey}")
    String routingKey;

    @Value("${sample.rabbitmq.queue}")
    String queueName;

    public UserServiceImp(UserRepo userRepo, DirectExchange exchange, RabbitTemplate rabbitTemplate) {
        this.userRepo = userRepo;
        this.exchange = exchange;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void createUser(UserDto userDto) {

        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, userDto);


    }
    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

}

