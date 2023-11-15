package cphbusiness.noInPuts.authService.service;

import cphbusiness.noInPuts.authService.dto.RestaurantDTO;
import cphbusiness.noInPuts.authService.dto.RestaurantEmployeeDTO;
import cphbusiness.noInPuts.authService.exception.UserDoesNotExistException;
import cphbusiness.noInPuts.authService.exception.WrongCredentialsException;
import cphbusiness.noInPuts.authService.model.RestaurantEmployee;
import cphbusiness.noInPuts.authService.repository.RestaurantEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantEmployeeServiceImpl implements RestaurantEmployeeService {

    private final RestaurantEmployeeRepository restaurantEmployeeRepository;

    @Autowired
    public RestaurantEmployeeServiceImpl(RestaurantEmployeeRepository restaurantEmployeeRepository) {
        this.restaurantEmployeeRepository = restaurantEmployeeRepository;
    }

    public RestaurantEmployeeDTO login(String username, String password) throws UserDoesNotExistException, WrongCredentialsException {
        Optional<RestaurantEmployee> restaurantEmployeeOptional = restaurantEmployeeRepository.findByUsername(username);

        if(restaurantEmployeeOptional.isPresent()) {
            RestaurantEmployee restaurantEmployee = restaurantEmployeeOptional.get();

            if(!restaurantEmployee.getPassword().equals(password)) {
                throw new WrongCredentialsException("Wrong password");
            }

            RestaurantDTO restaurantDTO = new RestaurantDTO(restaurantEmployee.getRestaurant().getId(), restaurantEmployee.getRestaurant().getName(), null);
            return new RestaurantEmployeeDTO(restaurantEmployee.getId(), restaurantEmployee.getUsername(), null, restaurantDTO);
        } else {
            throw new UserDoesNotExistException("User does not exist");
        }
    }
}
