package cphbusiness.noInPuts.authService.repository;

import cphbusiness.noInPuts.authService.model.Restaurant;
import cphbusiness.noInPuts.authService.model.RestaurantEmployee;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RestaurantEmployeeTests {

    @Autowired
    private RestaurantEmployeeRepository restaurantEmployeeRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void getRestaurantEmployeesByRestaurantId() {
        // Creating object that can generate fake data
        Faker faker = new Faker();

        // Creating a restaurant object with a random restaurant name and saving it in the DB
        Restaurant restaurant = new Restaurant(faker.restaurant().name());
        Restaurant restaurantEntity = restaurantRepository.save(restaurant);

        // Creating a restaurant employee object with a random name and the restaurant object created above and saving it in the DB
        String employeeName = faker.name().fullName();
        RestaurantEmployee restaurantEmployee = new RestaurantEmployee(employeeName, "employee_user", "password", restaurantEntity);
        restaurantEmployeeRepository.save(restaurantEmployee);

        // Getting the restaurant employee object from the DB by the restaurant id
        List<RestaurantEmployee> restaurantEmployeeEntity = restaurantEmployeeRepository.findAllByRestaurantId(restaurantEntity.getId());

        assertNotNull(restaurantEmployeeEntity);
        assertEquals(employeeName, restaurantEmployeeEntity.get(0).getName());
    }
}
