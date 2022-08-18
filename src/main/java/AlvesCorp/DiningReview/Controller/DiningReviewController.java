package AlvesCorp.DiningReview.Controller;

import AlvesCorp.DiningReview.Model.DiningReview;
import AlvesCorp.DiningReview.Service.DiningReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/DiningReview")
public class DiningReviewController {
    private final DiningReviewService diningReviewService;

    public DiningReviewController(DiningReviewService diningReviewService) {
        this.diningReviewService = diningReviewService;
    }

    @GetMapping()
    public List<DiningReview> getAllDiningReview() {
        return this.diningReviewService.getAllDiningReviews();
    }

    @PostMapping("/{username}")
    public DiningReview postReview(@PathVariable String username, @RequestBody DiningReview review) {
        Optional<DiningReview> res = this.diningReviewService.submitDiningReview(username,review);
        if(res.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return res.get();
    }

    @GetMapping("/{restaurant}")
    public Set<DiningReview> getReviewsFromRestaurant(@PathVariable String restaurant){
        Set<DiningReview> res = this.diningReviewService.allReviewsFromRestaurant(restaurant);
        if(res.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return res;
    }
}
