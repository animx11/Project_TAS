package Spring.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BandsRating", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class BandsRatings {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Bands", referencedColumnName = "id")
    private Bands bands;

    @Column(name = "Rating")
    private int rating;

    public BandsRatings() {
    }

    public BandsRatings(Bands bands, int rating) {
        this.bands = bands;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bands getBands() {
        return bands;
    }

    public void setBands(Bands bands) {
        this.bands = bands;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
