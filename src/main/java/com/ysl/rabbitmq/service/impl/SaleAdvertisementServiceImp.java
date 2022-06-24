package com.ysl.rabbitmq.service.impl;

import com.ysl.rabbitmq.dao.SaleAdvertisementRepo;
import com.ysl.rabbitmq.dto.SaleAdvertisementDto;
import com.ysl.rabbitmq.model.SaleAdvertisement;
import com.ysl.rabbitmq.service.SaleAdvertisementService;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleAdvertisementServiceImp implements SaleAdvertisementService {

    private final SaleAdvertisementRepo saleAdvertisementRepo;
    private final DirectExchange exchange;
    private final RabbitTemplate rabbitTemplate;

    @Value("${sample.rabbitmq.routingKey}")
    String routingKey;

    @Value("${sample.rabbitmq.queue}")
    String queueName;

    public SaleAdvertisementServiceImp(SaleAdvertisementRepo saleAdvertisementRepo, DirectExchange exchange, RabbitTemplate rabbitTemplate) {
        this.saleAdvertisementRepo = saleAdvertisementRepo;
        this.exchange = exchange;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void createSaleAdvertisement(SaleAdvertisementDto saleAdvertisementDto) {

        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, saleAdvertisementDto);

    }

    @Override
    public List<SaleAdvertisement> getAllSaleAdvertisements() {
        return saleAdvertisementRepo.findAll();
    }

    @Override
    public List<SaleAdvertisement> findByCreatedAtAfter(Date afterDate) {
        return saleAdvertisementRepo.findByCreatedAtAfter(afterDate);
    }

    @Override
    public List<SaleAdvertisement> getSaleAdvertisementsByTitleOrDetailMessage(String title, String detail) {
        return saleAdvertisementRepo.findSaleAdvertisementsByTitleOrDetailMessage(title, detail);
    }

    @Override
    public List<SaleAdvertisement> findByPriceGreaterThan(Long price) {
        return saleAdvertisementRepo.findByPriceGreaterThan(price);
    }



}
