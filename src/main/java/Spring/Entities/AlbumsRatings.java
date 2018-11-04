package Spring.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Albums", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class AlbumsRatings {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Albums", referencedColumnName = "id")
    private Albums album;

    @Column(name = "Rating")
    private int rating;

    public AlbumsRatings() {
    }

    public AlbumsRatings(Albums album, int rating) {
        this.album = album;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Albums getAlbum() {
        return album;
    }

    public void setAlbum(Albums album) {
        this.album = album;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
