package com.ced.config;

import com.ced.properties.AmqpProperties;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    private final AmqpProperties amqpProperties;

    public AmqpConfig(AmqpProperties amqpProperties) {
        this.amqpProperties = amqpProperties;
    }

    @Bean
    public Queue refreshQueue() {
        return new Queue(amqpProperties.getQueueName(), true);
    }

    @Bean
    public DirectExchange refreshExchange() {
        return new DirectExchange(amqpProperties.getExchangeName());
    }

    @Bean
    public Binding binding(Queue refreshQueue, DirectExchange refreshExchange) {
        return BindingBuilder.bind(refreshQueue)
                .to(refreshExchange)
                .with(amqpProperties.getRoutingKey());
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}