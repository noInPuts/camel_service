package cphbusiness.noinputs.main.service;

import cphbusiness.noinputs.main.dto.RestaurantDTO;
import cphbusiness.noinputs.main.model.Restaurant;
import cphbusiness.noinputs.main.repository.RestaurantRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RestaurantServiceTests {

    @Autowired
    private RestaurantService restaurantService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    @Test
    public void getAllRestaurants() {
        Faker faker = new Faker();
        List<String> restaurantNames = new ArrayList<>();

        for(long i = 1L; i<4L; i++) {
            restaurantNames.add(faker.restaurant().name());
        }

        when(restaurantRepository.findAll()).thenReturn(
                List.of(
                        new Restaurant(1L, restaurantNames.get(0)),
                        new Restaurant(2L, restaurantNames.get(1)),
                        new Restaurant(3L, restaurantNames.get(2))
                )
        );
        List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();

        assertEquals(3, restaurants.size());
        assertEquals(restaurantNames.get(0), restaurants.get(0).getName());
        assertEquals(restaurantNames.get(1), restaurants.get(1).getName());
        assertEquals(restaurantNames.get(2), restaurants.get(2).getName());
    }
}
