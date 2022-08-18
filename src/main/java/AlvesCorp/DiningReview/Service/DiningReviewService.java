package AlvesCorp.DiningReview.Service;

import AlvesCorp.DiningReview.Model.DiningReview;
import AlvesCorp.DiningReview.Model.User;

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
public interface DiningReviewService {

    Optional<DiningReview > submitDiningReview(String username, DiningReview diningReview);

    List<DiningReview> getAllDiningReviews();

    Boolean decideReview(String username, DiningReview diningReview, Boolean Decision);

    Set<DiningReview> allReviewsFromRestaurant(String Restaurant);


}
