package cphbusiness.noInPuts.apache_camel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// TODO: Comments/Documentation
@Component
public class RabbitCamelRoutes extends RouteBuilder {

    // TODO: Create multiple files for each route
    // TODO: Give route a name (Displays route1 in logs)
    @Override
    public void configure() {
        from("spring-rabbitmq:default?queues=userCreated&routingKey=userCreated")
                .log(LoggingLevel.INFO, "User is created: ${body}")
                .to("spring-rabbitmq:default?queues=persistUserInUserService&routingKey=persistUserInUserService");
    }
}
