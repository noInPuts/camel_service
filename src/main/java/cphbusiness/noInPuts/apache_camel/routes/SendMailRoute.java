package cphbusiness.noInPuts.apache_camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SendMailRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sendEmail")
                .process(exchange -> {
                    exchange.getMessage().setBody(exchange.getIn().getBody(String.class));
                })
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .to("http://localhost:3002/sendmail?throwExceptionOnFailure=false");

        from("spring-rabbitmq:default?queues=sendEmail&routingKey=sendEmail")
                .log(LoggingLevel.INFO, "Received message from RabbitMQ: ${body}")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    exchange.getMessage().setBody(body);
                })
                .to("direct:sendEmail");
    }
}
