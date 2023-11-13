package cphbusiness.noinputs.main.repository;

import cphbusiness.noinputs.main.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RestaurantRepositoryTests {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void findAll() {
        restaurantRepository.save(new Restaurant(1L, "McDonald"));
        restaurantRepository.save(new Restaurant(2L, "Burger king"));
        restaurantRepository.save(new Restaurant(3L, "Taco bell"));

        List<Restaurant> restaurants = restaurantRepository.findAll();

        assertEquals(3, restaurants.size());
        assertTrue(restaurants.stream().anyMatch(restaurant -> restaurant.getName().equals("McDonald")));
        assertTrue(restaurants.stream().anyMatch(restaurant -> restaurant.getName().equals("Burger king")));
        assertTrue(restaurants.stream().anyMatch(restaurant -> restaurant.getName().equals("Taco bell")));
    }
}
