package cphbusiness.noinputs.main.repository;

import cphbusiness.noinputs.main.model.Restaurant;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RestaurantRepositoryTests {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void findAll() {
        Faker faker = new Faker();
        List<String> restaurantNames = new ArrayList<>();

        for(long i = 1L; i<4L; i++) {
            String restaurantName = faker.restaurant().name();
            restaurantNames.add(restaurantName);
            restaurantRepository.save(new Restaurant(i, restaurantName));
        }

        List<Restaurant> restaurants = restaurantRepository.findAll();

        assertEquals(3, restaurants.size());
        for(String restaurantName : restaurantNames) {
            assertTrue(restaurants.stream().anyMatch(restaurant -> restaurant.getName().equals(restaurantName)));
        }
    }
}
