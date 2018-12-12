package Spring.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SongsComments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class SongsComments{
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
    @JoinColumn(name = "Songs", referencedColumnName = "id")
    private Songs songs;

    public SongsComments() {
    }

    public SongsComments(String content, int rating) {
        this.content = content;
        this.rating = rating;
    }

    public int getId() {return id;}
    public String getContent() {return content;}
    public int getRating() {return rating;}
    public void setContent(String content) {this.content = content;}
}