package cphbusiness.noinputs.main.controller;

import cphbusiness.noinputs.main.dto.RestaurantDTO;
import cphbusiness.noinputs.main.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RestaurantControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void testGetAllRestaurants() throws Exception {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        restaurantDTOList.add(new RestaurantDTO(1L, "McDonalds"));
        restaurantDTOList.add(new RestaurantDTO(2L,"Burger king"));
        restaurantDTOList.add(new RestaurantDTO(3L,"Taco bell"));

        when(restaurantService.getAllRestaurants()).thenReturn(restaurantDTOList);

        this.mockMvc.perform(get("/restaurants").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"McDonalds\"},{\"name\":\"Burger king\"},{\"name\":\"Taco bell\"}]"));
    }
}
