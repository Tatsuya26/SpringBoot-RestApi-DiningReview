package AlvesCorp.DiningReview.Service;

import AlvesCorp.DiningReview.Model.Restaurant;
import AlvesCorp.DiningReview.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImplementation implements RestaurantService{


    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImplementation(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public Optional<Restaurant> addRestaurant(Restaurant restaurant) {
        Optional<Restaurant> result_restaurant = this.restaurantRepository.findByName(restaurant.getName());
        if(result_restaurant.isEmpty()) {
            this.restaurantRepository.save(restaurant);
        }
        return result_restaurant;
    }

    @Override
    public Iterable<Restaurant> getRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantFromCityWithReview(String city) {
        List<Restaurant> aux = this.restaurantRepository.findAllByCity(city);
        List<Restaurant> res = new ArrayList<>();
        for(Restaurant r: aux) {
            if(!(r.get_reviews().isEmpty()))  res.add(r);
        }
        return res;
    }

    @Override
    public Optional<Restaurant> getRestaurantById(long id) {
        return this.restaurantRepository.findById(id);
    }
}
