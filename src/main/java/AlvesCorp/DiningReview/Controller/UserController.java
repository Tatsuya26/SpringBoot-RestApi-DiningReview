package AlvesCorp.DiningReview.Controller;

import AlvesCorp.DiningReview.Model.User;
import AlvesCorp.DiningReview.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }


    @PostMapping()
    public User createUser(@RequestBody User user) {
        Optional<User> res = this.userService.CreateUser(user);
        if(res.isEmpty()) throw new ResponseStatusException(HttpStatus.CONFLICT);
        return res.get();
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        Optional<User> res = this.userService.UpdateUser(user);
        if(res.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else return res.get();
    }

    @GetMapping("/{username}")
    public User getUserByUserName(@PathVariable String username) {
        Optional<User> aux = this.userService.getUser(username);
        if(aux.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else return aux.get();
    }


}
