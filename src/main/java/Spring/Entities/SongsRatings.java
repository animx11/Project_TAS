package Spring.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Albums", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class SongsRatings {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Songs", referencedColumnName = "id")
    private Bands song;

    @Column(name = "Rating")
    private int rating;
    public int getId() {
        return id;
    }

    public SongsRatings() {
    }

    public SongsRatings(Bands songs, int rating) {
        this.song = songs;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bands getSongs() {
        return song;
    }

    public void setSongs(Bands songs) {
        this.song = songs;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
