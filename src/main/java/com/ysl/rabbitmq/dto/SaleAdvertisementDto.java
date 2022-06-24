package com.ysl.rabbitmq.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class SaleAdvertisementDto {

    private String userMail;

    private String photo;

    private String title;

    private String detailMessage;

    private Long price;

    private Long userFk;


}
