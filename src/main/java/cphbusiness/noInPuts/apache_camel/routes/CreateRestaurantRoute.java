package cphbusiness.noInPuts.apache_camel.routes;

import cphbusiness.noInPuts.apache_camel.service.JwtService;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CreateRestaurantRoute extends RouteBuilder {

    @Value("${service.restaurant.url}")
    private String restaurantServiceAddress;

    private final JwtService jwtService;

    @Autowired
    public CreateRestaurantRoute(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void configure(){
        String cookie = jwtService.tokenGenerator(1L, "admin", "admin");
        from("spring-rabbitmq:default?queues=createRestaurant&routingKey=createRestaurant")
                .process(exchange -> {
                    exchange.getMessage().setBody(exchange.getIn().getBody(String.class));
                    exchange.getMessage().setHeader("Cookie", "jwt-token="+cookie+"; Path=/; HttpOnly");
                })
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .to(restaurantServiceAddress+"/api/restaurant/restaurants?throwExceptionOnFailure=false")
                .log(LoggingLevel.INFO, "Restaurant created");
    }
}
