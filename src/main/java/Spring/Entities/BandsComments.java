package Spring.Entities;

import javax.persistence.*;
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

    public BandsComments() {
    }

    public BandsComments(String content, int rating, Users userName, Bands bands) {
        this.content = content;
        this.rating = rating;
        this.userName = userName;
        this.bands = bands;
    }

    public int getId() {return id;}
    public String getContent() {return content;}
    public int getRating() {return rating;}
    public void setContent(String content) {this.content = content;}
}