package Spring.Entities;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "date")
    private Date commentsDate = new Date();

    public SongsComments() {
    }

    public SongsComments(String content, int rating, Users userName, Songs songs) {
        this.content = content;
        this.rating = rating;
        this.userName = userName;
        this.songs = songs;
        this.commentsDate = new Date();
    }

    public int getId() {return id;}
    public String getContent() {return content;}
    public int getRating() {return rating;}
    public Date getDate() {return commentsDate;}
    public void setContent(String content) {this.content = content;}
}