package AlvesCorp.DiningReview.Repository;

import AlvesCorp.DiningReview.Model.DiningReview;
import AlvesCorp.DiningReview.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Optional<Restaurant> findByName(String name);
    List<Restaurant> findAllByCity(String city);


}
