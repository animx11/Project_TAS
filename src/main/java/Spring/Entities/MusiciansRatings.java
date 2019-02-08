package Spring.Entities;

import javax.persistence.*;

@Entity
@Table(name = "MusicansRating", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class MusiciansRatings {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Musicians", referencedColumnName = "id")
    private Musicians musician;

    @Column(name = "Rating")
    private int rating;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Users", referencedColumnName = "id")
    private Users userName;

    public MusiciansRatings() {
    }

    public MusiciansRatings(Musicians musician, int rating, Users userName) {
        this.musician = musician;
        this.rating = rating;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Musicians getMusician() {
        return musician;
    }

    public void setMusician(Musicians musician) {
        this.musician = musician;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
