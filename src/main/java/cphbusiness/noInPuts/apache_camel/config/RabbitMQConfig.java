package cphbusiness.noInPuts.apache_camel.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Queue for creating users
    @Bean
    public Queue userCreated() {
        return new Queue("userCreated");
    }

    @Bean
    public Queue persistUserInUserService() {
        return new Queue("persistUserInUserService");
    }

}
