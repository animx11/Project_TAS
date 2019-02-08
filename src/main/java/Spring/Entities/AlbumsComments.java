package Spring.Entities;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "date")
    private Date commentsDate = new Date();

    public AlbumsComments() {
    }

    public AlbumsComments(String content, Users userName, Albums albums) {
        this.content = content;
        this.rating = 0;
        this.userName = userName;
        this.albums = albums;
        this.commentsDate = new Date();
    }

    public int getId() {return id;}
    public String getContent() {return content;}
    public int getRating() {return rating;}
    public Date getDate() {return commentsDate;}
    public void setContent(String content) {this.content = content;}
}
