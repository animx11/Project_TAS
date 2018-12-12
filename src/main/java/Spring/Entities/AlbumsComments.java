package Spring.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AlbumsComments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class AlbumsComments {
    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "User", referencedColumnName = "id")
    private Users userName;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private int rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Albums", referencedColumnName = "id")
    private Albums albums;

    public AlbumsComments() {
    }

    public AlbumsComments(String content, int rating) {
        this.content = content;
        this.rating = rating;
    }

    public int getId() {return id;}
    public String getContent() {return content;}
    public int getRating() {return rating;}
}
