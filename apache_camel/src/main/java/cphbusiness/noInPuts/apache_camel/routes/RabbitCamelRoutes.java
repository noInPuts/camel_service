package cphbusiness.noInPuts.apache_camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class RabbitCamelRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("spring-rabbitmq:default?queues=userCreatedQueue&routingKey=userCreatedQueue")
                .log(LoggingLevel.INFO, "Received message from RabbitMQ: ${body}");
    }
}
