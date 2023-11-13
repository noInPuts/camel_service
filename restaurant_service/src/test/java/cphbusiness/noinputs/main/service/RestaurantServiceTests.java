package cphbusiness.noinputs.main.service;

import cphbusiness.noinputs.main.dto.RestaurantDTO;
import cphbusiness.noinputs.main.model.Restaurant;
import cphbusiness.noinputs.main.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
        when(restaurantRepository.findAll()).thenReturn(
                List.of(
                        new Restaurant(1L, "McDonald"),
                        new Restaurant(2L, "Burger king"),
                        new Restaurant(3L, "Taco bell")
                )
        );
        List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();

        assertEquals(3, restaurants.size());
        assertEquals("McDonald", restaurants.get(0).getName());
        assertEquals("Burger king", restaurants.get(1).getName());
        assertEquals("Taco bell", restaurants.get(2).getName());
    }
}
