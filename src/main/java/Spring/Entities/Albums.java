package Spring.Entities;

import javax.persistence.*;

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
/*
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Band", referencedColumnName = "id")
    private Bands band;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Songs", referencedColumnName = "id")
    private Songs songs;
*/
    @Column(name = "Lenght_Of_Album")
    private int lengthOfAlbum;

    @Column(name = "Averange_Rate_Of_Album")
    private float averangeRateOfAlbum;

    //Constructors

    public Albums(){
    }

    public Albums(String albumName, int lengthOfAlbum, float averangeRateOfAlbum) {
        this.albumName = albumName;
        this.lengthOfAlbum = lengthOfAlbum;
        this.averangeRateOfAlbum = averangeRateOfAlbum;
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
