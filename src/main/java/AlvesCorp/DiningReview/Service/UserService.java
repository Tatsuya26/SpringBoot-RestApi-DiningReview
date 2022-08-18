package AlvesCorp.DiningReview.Service;

import AlvesCorp.DiningReview.Model.User;
import java.util.List;
import java.util.Optional;


/*
User entity-related scenarios:
        As an unregistered user, I want to create my user profile using a display name that’s unique only to me.
        As a registered user, I want to update my user profile. I cannot modify my unique display name.
        As an application experience, I want to fetch the user profile belonging to a given display name.
        As part of the backend process that validates a user-submitted dining review, I want to verify that the user exists, based on the user display name associated with the dining review.
*/


public interface UserService {

    List<User> getAllUsers();
    Optional<User> CreateUser(User user);
    Optional<User> UpdateUser(User user);
    Optional<User> getUser(String username);
    Boolean isUserValid(String username);

}
