package Spring.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Songs", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class Songs {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "Song_Name")
    private String songName;

    @Column(name = "Year_of_creation")
    private int yearOfCreation;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Lenght_Of_Song")
    private int lengthOfSong;

    @Column(name = "Averange_Rate_Of_Song")
    private float averangeRateOfSong;

    @Column(name = "Albums")
    private String albums;


    @Column(name = "Band")
    private String band;

    public Songs() {
    }

    public Songs(String songName, int yearOfCreation, String genre, int lengthOfSong, float averangeRateOfSong) {
        this.songName = songName;
        this.yearOfCreation = yearOfCreation;
        this.genre = genre;
        this.lengthOfSong = lengthOfSong;
        this.averangeRateOfSong = averangeRateOfSong;
        //this.albums = albums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLengthOfSong() {
        return lengthOfSong;
    }

    public void setLengthOfSong(int lengthOfSong) {
        this.lengthOfSong = lengthOfSong;
    }

    public float getAverangeRateOfSong() {
        return averangeRateOfSong;
    }

    public void setAverangeRateOfSong(float averangeRateOfSong) {
        this.averangeRateOfSong = averangeRateOfSong;
    }

    public String getAlbums() {
        return albums;
    }

    public void setAlbums(String albums) {
        this.albums = albums;
    }



}
