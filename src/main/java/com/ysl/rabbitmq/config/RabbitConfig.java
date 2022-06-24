package com.ysl.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //application.properties string
    @Value("${sample.rabbitmq.exchange}")
    String exchangeSample;
    @Value("${sample.rabbitmq.queue}")
    String queueName;
    @Value("${sample.rabbitmq.routingKey}")
    String routingKey;

    //Queue oluşturur.
    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    //Exchange Type
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeSample);
    }

    //Verilen queue ismi, exchange ve rout ile bind işlemi yapmayı sağlar.
    @Bean
    Binding binding(Queue firstStepQueue, DirectExchange exchange) {
        return BindingBuilder.bind(firstStepQueue).to(exchange).with(routingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") ConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }


}
