package AlvesCorp.DiningReview.Service;

import AlvesCorp.DiningReview.Model.DiningReview;
import AlvesCorp.DiningReview.Model.Restaurant;
import AlvesCorp.DiningReview.Model.User;
import AlvesCorp.DiningReview.Repository.DiningReviewRepository;
import AlvesCorp.DiningReview.Repository.RestaurantRepository;
import AlvesCorp.DiningReview.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/*
Dining review entity-related scenarios:

    As a registered user, I want to submit a dining review.
    As an admin, I want to get the list of all dining reviews that are pending approval.
    As an admin, I want to approve or reject a given dining review.
    As part of the backend process that updates a restaurant’s set of scores, I want to fetch the set of all approved dining reviews belonging to this restaurant.

 */
@Service
public class DiningReviewServiceImplementation implements DiningReviewService {


    private final DiningReviewRepository diningReviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public DiningReviewServiceImplementation(DiningReviewRepository diningReviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.diningReviewRepository = diningReviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public Optional<DiningReview> submitDiningReview(String username, DiningReview diningReview) {
        Optional<User> user = this.userRepository.findByUserName(username);
        Optional<Restaurant> restaurant = this.restaurantRepository.findByName(diningReview.getRestaurant_name());
        Optional<DiningReview> res;
        if(user.isEmpty() || restaurant.isEmpty()) res = Optional.empty();
        else {
            diningReview.setUser(user.get());
            diningReview.setRestaurantReviewed_Id(restaurant.get());
            res = Optional.of(this.diningReviewRepository.save(diningReview));
        }
        return res;
    }

    @Override
    public List<DiningReview> getAllDiningReviews() {
        return this.diningReviewRepository.findAll();
    }

    @Override
    public Boolean decideReview(String username, DiningReview diningReview, Boolean Decision) {
        return null;
    }

    @Override
    public Set<DiningReview> allReviewsFromRestaurant(String Restaurant) {
        Optional<Restaurant> r = this.restaurantRepository.findByName(Restaurant);
        Set<DiningReview> res;
        if(r.isPresent()) res = r.get().get_reviews();
        else res = Set.of();
        return res;
    }
}
