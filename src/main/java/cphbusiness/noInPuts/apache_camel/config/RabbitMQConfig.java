package cphbusiness.noInPuts.apache_camel.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    // RabbitMQ connection config
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");

        // TODO: Change this to secrets in production
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        return connectionFactory;
    }

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
