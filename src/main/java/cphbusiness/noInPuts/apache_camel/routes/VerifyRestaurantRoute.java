package cphbusiness.noInPuts.apache_camel.routes;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class VerifyRestaurantRoute extends RouteBuilder {
    @Override
    public void configure() {
        // gRPC -> REST

        /*
        // Kafka
        from("kafka:getRestaurant?brokers=localhost:9092")
                .setExchangePattern(ExchangePattern.InOut)
                .log("Restaurant is verified: ${body}");

        // RabbitMQ
        from("spring-rabbitmq:default?queues=userCreated&routingKey=userCreated")
                .log(LoggingLevel.INFO, "User is created: ${body}")
                .to("spring-rabbitmq:default?queues=persistUserInUserService&routingKey=persistUserInUserService");
        */
    }
}
