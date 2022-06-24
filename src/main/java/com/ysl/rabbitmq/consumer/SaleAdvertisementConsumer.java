package com.ysl.rabbitmq.consumer;

import com.ysl.rabbitmq.dao.SaleAdvertisementRepo;
import com.ysl.rabbitmq.model.SaleAdvertisement;
import com.ysl.rabbitmq.utility.AdvertisementGenerator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SaleAdvertisementConsumer {

    private final SaleAdvertisementRepo saleAdvertisementRepo;
    private final UserConsumer userConsumer;
    Random random = new Random();

    public SaleAdvertisementConsumer(SaleAdvertisementRepo saleAdvertisementRepo, UserConsumer userConsumer) {
        this.saleAdvertisementRepo = saleAdvertisementRepo;
        this.userConsumer = userConsumer;
    }

    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public void listener(SaleAdvertisement saleAdvertisement) {

        try {
            Thread.sleep(5 * 1000);
            saleAdvertisement.setPriceGraphPath("created by Worker");
            saleAdvertisement.setPhoto("photoString...");
            saleAdvertisement.setTitle(AdvertisementGenerator.generateTitle());
            saleAdvertisement.setUserFk(userConsumer.getRandomUser());
            saleAdvertisement.setDetailMessage(AdvertisementGenerator.generateDescription());
            saleAdvertisement.setPrice(random.nextLong(100000));
            saleAdvertisementRepo.save(saleAdvertisement);

        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }

    }

}
