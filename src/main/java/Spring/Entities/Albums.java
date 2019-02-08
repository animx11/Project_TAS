package Spring.Entities;

import javax.persistence.*;
import java.util.List;
import Spring.Entities.Bands;

@Entity
@Table(name = "Albums", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class Albums {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "Album_Name")
    private String albumName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Band", referencedColumnName = "id")
    private Bands band;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Songs", referencedColumnName = "id")
    private List<Songs> songs;

    @Column(name = "Lenght_Of_Album")
    private int lengthOfAlbum;

    @Column(name = "Average_Rate_Of_Album")
    private float averangeRateOfAlbum;

    //Constructors

    public Albums(){
    }

    public Albums(String albumName, int lengthOfAlbum, float averangeRateOfAlbum, Bands band ) {
        this.albumName = albumName;
        this.lengthOfAlbum = lengthOfAlbum;
        this.averangeRateOfAlbum = averangeRateOfAlbum;
        this.band = band;
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getLengthOfAlbum() {
        return lengthOfAlbum;
    }

    public void setLengthOfAlbum(int lengthOfAlbum) {
        this.lengthOfAlbum = lengthOfAlbum;
    }

    public float getAverangeRateOfAlbum() {
        return averangeRateOfAlbum;
    }

    public void setAverangeRateOfAlbum(float averangeRateOfAlbum) {
        this.averangeRateOfAlbum = averangeRateOfAlbum;
    }
}
