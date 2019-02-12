package Spring.Entities;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "Band")
    private String band;

    @Column(name = "Songs")
    private String songs;

    @Column(name = "Lenght_Of_Album")
    private int lengthOfAlbum;

    @Column(name = "Average_Rate_Of_Album")
    private float averageRateOfAlbum;

    //Constructors

    public Albums(){
    }

    public Albums(String albumName, int lengthOfAlbum, String band, float averageRateOfAlbum) {
        this.albumName = albumName;
        this.lengthOfAlbum = lengthOfAlbum;
        this.band = band;
        this.averageRateOfAlbum = averageRateOfAlbum;
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
        return averageRateOfAlbum;
    }

    public void setAverangeRateOfAlbum(float averageRateOfAlbum) {
        this.averageRateOfAlbum = averageRateOfAlbum;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }
    public String getSongs(){
        return songs;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
