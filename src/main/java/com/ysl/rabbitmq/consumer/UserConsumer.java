package com.ysl.rabbitmq.consumer;

import com.ysl.rabbitmq.dao.UserRepo;
import com.ysl.rabbitmq.model.User;
import com.ysl.rabbitmq.utility.UserGenerator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {
    private final UserRepo userRepo;

    public UserConsumer(UserRepo userRepo){
        this.userRepo = userRepo;
    }


    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public void userListener(User user) {
        String name = UserGenerator.generateFirstName();
        String lastName = UserGenerator.generateLastName();
        try {
            Thread.sleep(5 * 1000L);
            user.setFirstName(name);
            user.setLastName(lastName);
            user.setUserMail(UserGenerator.generateEmail(name, lastName));
            userRepo.save(user);

        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }

    }
    public Long getRandomUser() {
        return userRepo.generateUser().getUserId();
    }


}
