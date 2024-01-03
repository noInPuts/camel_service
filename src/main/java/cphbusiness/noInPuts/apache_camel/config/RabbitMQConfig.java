package cphbusiness.noInPuts.apache_camel.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue createRestaurant() {
        return new Queue("createRestaurant");
    }

}
