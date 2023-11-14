package cphbusiness.noInPuts.authService.repository;

import cphbusiness.noInPuts.authService.model.RestaurantEmployee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantEmployeeRepository extends CrudRepository<RestaurantEmployee, Long> {
    List<RestaurantEmployee> findAllByRestaurantId(Long id);
}
