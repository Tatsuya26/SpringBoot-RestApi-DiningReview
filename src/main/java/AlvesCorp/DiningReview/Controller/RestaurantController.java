package AlvesCorp.DiningReview.Controller;

import AlvesCorp.DiningReview.Model.Restaurant;
import AlvesCorp.DiningReview.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Restaurant")

public class RestaurantController {

    private final RestaurantService restaurantService;


    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /*
    Get All restaurants
     */
    @GetMapping()
    public Iterable<Restaurant> getRestaurants() {
        return this.restaurantService.getRestaurants();
    }

    /*
     Should a restaurant with the same name already exist, I will see a failure.
     */
    @PostMapping()
    public void addRestaurant(@RequestBody Restaurant restaurant ) {
        Optional<Restaurant> result_restaurant = this.restaurantService.addRestaurant(restaurant);
        if(result_restaurant.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    /*
    fetch the details of a restaurant, given its unique Id.
     */
    @GetMapping("/byId/{id}")
    public Restaurant getRestaurant(@PathVariable long id) {
        Optional<Restaurant> aux = this.restaurantService.getRestaurantById(id);
        if(aux.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return aux.get();
    }


    @GetMapping("/byCity/{city}")
    public List<Restaurant> getRestaurantFromCityWithReview(@PathVariable String city) {
        List<Restaurant> restaurants = this.restaurantService.getRestaurantFromCityWithReview(city);
        if(restaurants.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return restaurants;
    }
}
