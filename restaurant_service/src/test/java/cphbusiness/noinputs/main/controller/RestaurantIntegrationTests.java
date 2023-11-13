package cphbusiness.noinputs.main.controller;

import cphbusiness.noinputs.main.model.Restaurant;
import cphbusiness.noinputs.main.repository.RestaurantRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RestaurantIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void getAllRestaurants() throws Exception {
        Faker faker = new Faker();
        List<String> restaurantNames = new ArrayList<>();

        for(long i = 1L; i<4L; i++) {
            String restaurantName = faker.restaurant().name();
            restaurantNames.add(restaurantName);
            restaurantRepository.save(new Restaurant(i, restaurantName));
        }

        this.mockMvc.perform(get("/restaurants").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\""+ restaurantNames.get(0) +"\"},{\"name\":\""+ restaurantNames.get(1) +"\"},{\"name\":\""+ restaurantNames.get(2) +"\"}]"));
    }
}
