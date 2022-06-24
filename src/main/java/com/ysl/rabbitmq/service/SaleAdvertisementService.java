package com.ysl.rabbitmq.service;

import com.ysl.rabbitmq.dto.SaleAdvertisementDto;
import com.ysl.rabbitmq.model.SaleAdvertisement;

import java.util.Date;
import java.util.List;

public interface SaleAdvertisementService {

    void createSaleAdvertisement(SaleAdvertisementDto saleAdvertisementDto);


    List<SaleAdvertisement> getAllSaleAdvertisements();

    List<SaleAdvertisement> findByCreatedAtAfter(Date afterDate);

    List<SaleAdvertisement> getSaleAdvertisementsByTitleOrDetailMessage(String title,String detail);

    List<SaleAdvertisement> findByPriceGreaterThan(Long price);







}
