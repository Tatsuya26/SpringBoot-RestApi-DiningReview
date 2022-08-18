package AlvesCorp.DiningReview.Service;

import AlvesCorp.DiningReview.Model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    Optional<Restaurant> addRestaurant(Restaurant restaurant);

    Iterable<Restaurant> getRestaurants();
    List<Restaurant> getRestaurantFromCityWithReview(String city);

    Optional<Restaurant> getRestaurantById(long id);

}
