package com.ced.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "amqp")
public class AmqpProperties {
    private String queueName;
    private String exchangeName;
    private String routingKey;
}