package AlvesCorp.DiningReview.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "city")
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurantReviewed_Id")
    private Set<DiningReview> reviews = new HashSet<>();

    @Column(name = "TOTAL_RATE")
    private float Total_Rate;

    public Restaurant() {
        setTotal_Rate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotal_Rate() {
        return Total_Rate;
    }

    public void setTotal_Rate() {
        float rate = 0;
        int count = 0;
        for(DiningReview r : this.reviews) {
            rate += r.getRate();
            count++;
        }
        this.Total_Rate = (float) rate / count;
    }

    public Set<DiningReview> get_reviews() {
        return reviews;
    }




}
