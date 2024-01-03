package cphbusiness.noInPuts.apache_camel.routes;

import cphbusiness.noinputs.order_service.main.proto.OrderRoutes;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VerifyRestaurantRoute extends RouteBuilder {

    @Value("${service.restaurant.url}")
    private String restaurantServiceAddress;

    @Override
    public void configure() {
        from("grpc://0.0.0.0:9090/cphbusiness.noinputs.order_service.main.proto.GetRestaurant?method=GetRestaurant")
                .process(exchange -> {
                    OrderRoutes.GetRestaurantRequest request = exchange.getIn().getBody(OrderRoutes.GetRestaurantRequest.class);

                    long restaurantId = request.getRestaurantId();
                    exchange.getIn().setHeader("restaurantId", restaurantId);
                    exchange.getIn().setBody(null);
                })
                .toD(restaurantServiceAddress+"/api/restaurant/restaurants/${header.restaurantId}?throwExceptionOnFailure=false")
                .process(exchange -> {
                    Integer statusCode = exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class);

                    String body = exchange.getIn().getBody(String.class);
                    JSONObject jsonObject = new JSONObject(body);

                    OrderRoutes.GetRestaurantResponse.Builder builder = OrderRoutes.GetRestaurantResponse.newBuilder()
                            .setValid(statusCode == 200)
                            .setName(jsonObject.getString("name"));

                    JSONArray menuItems = jsonObject.getJSONArray("menu");
                    for (int i = 0; i < menuItems.length(); i++) {
                        JSONObject menuItemJson = menuItems.getJSONObject(i);
                        OrderRoutes.MenuItems menuItem = OrderRoutes.MenuItems.newBuilder()
                                .setName(menuItemJson.getString("name"))
                                .setPrice(menuItemJson.getInt("price"))
                                .setId(menuItemJson.getLong("id"))
                                .build();

                        builder.addMenuItems(menuItem);
                    }

                    OrderRoutes.GetRestaurantResponse response = builder.build();
                    exchange.getMessage().setBody(response);
                })
                .log("Restaurant verification request from order service");
        /*
        // Kafka
        from("kafka:getRestaurant?brokers=localhost:9092")
                .setExchangePattern(ExchangePattern.InOut)
                .log("Restaurant is verified: ${body}");
        */

    }
}
