package Spring.Entities;

import javax.persistence.*;

@Entity
@Table(name = "SongsRating", uniqueConstraints = {
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Users", referencedColumnName = "id")
    private Users userName;

    @Column(name = "Rating")
    private int rating;
    public int getId() {
        return id;
    }

    public SongsRatings() {
    }

    public SongsRatings(Bands songs, int rating, Users userName) {
        this.song = songs;
        this.rating = rating;
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bands getSongs() {
        return song;
    }

    public Users getUser() {return userName;}

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
