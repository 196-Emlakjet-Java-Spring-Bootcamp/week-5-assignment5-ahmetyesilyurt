package com.ysl.rabbitmq.dao;

import com.ysl.rabbitmq.model.SaleAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SaleAdvertisementRepo extends JpaRepository<SaleAdvertisement, Long> {

    List<SaleAdvertisement> findByCreatedAtAfter(Date afterDate);

    List<SaleAdvertisement> findSaleAdvertisementsByTitleOrDetailMessage(String title,String detail);

    List<SaleAdvertisement> findByPriceGreaterThan(Long price);


}
