package AlvesCorp.DiningReview.Service;


import AlvesCorp.DiningReview.Model.User;
import AlvesCorp.DiningReview.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
User entity-related scenarios:
        As an unregistered user, I want to create my user profile using a display name that’s unique only to me.
        As a registered user, I want to update my user profile. I cannot modify my unique display name.
        As an application experience, I want to fetch the user profile belonging to a given display name.
        As part of the backend process that validates a user-submitted dining review, I want to verify that the user exists, based on the user display name associated with the dining review.
*/

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> CreateUser(User user) {
        Optional<User> aux = this.userRepository.findByUserName(user.getUserName());
        Optional<User> res;
        if(aux.isEmpty()) {
            res = Optional.of(this.userRepository.save(user));
        } else res = Optional.empty();
        return res;
    }

    @Override
    public Optional<User> UpdateUser(User user) {
        Optional<User> aux = this.userRepository.findById(user.getId());
        User res = null;
        if(aux.isPresent()) {
            res = aux.get();
            if(user.getCity() != null)     res.setCity(user.getCity());
            if(user.getPassword() != null) res.setPassword(user.getPassword());
            if(user.getState() != null)    res.setState(user.getState());
            if(user.getZipcode() != null)  res.setZipcode(user.getZipcode());
            res = this.userRepository.save(res);
        }
        return res == null ? Optional.empty() : Optional.of(res);
    }

    @Override
    public Optional<User> getUser(String username) {
        return this.userRepository.findByUserName(username);
    }


    public Boolean isUserValid(String username) {
        Optional<User> aux = this.userRepository.findByUserName(username);
        Boolean res = true;
        if(aux.isEmpty()) res = false;
        return res;
    }

}
