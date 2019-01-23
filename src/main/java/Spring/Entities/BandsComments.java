package Spring.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BandsComments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class BandsComments {
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
    @JoinColumn(name = "Bands", referencedColumnName = "id")
    private Bands bands;

    @Column(name = "date")
    private Date commentsDate = new Date();

    public BandsComments() {
    }

    public BandsComments(String content, int rating, Users userName, Bands bands) {
        this.content = content;
        this.rating = rating;
        this.userName = userName;
        this.bands = bands;
        this.commentsDate = new Date();
    }

    public int getId() {return id;}
    public String getContent() {return content;}
    public int getRating() {return rating;}
    public Date getDate() {return commentsDate;}
    public void setContent(String content) {this.content = content;}
}