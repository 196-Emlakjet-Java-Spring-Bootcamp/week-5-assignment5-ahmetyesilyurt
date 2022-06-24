package com.ysl.rabbitmq.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {

    private String firstName;

    private String lastName;

    private String userMail;


}
