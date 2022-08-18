package AlvesCorp.DiningReview.Repository;

import AlvesCorp.DiningReview.Model.DiningReview;
import AlvesCorp.DiningReview.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview,Long> {

}
