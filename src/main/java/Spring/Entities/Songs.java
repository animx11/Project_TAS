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

    @Column(name = "Title")
    private String Title;

    @Column(name = "Year_of_creation")
    private int yearOfCreation;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Lenght_Of_Song")
    private int lengthOfSong;

    @Column(name = "Averange_Rate_Of_Song")
    private float averangeRateOfSong;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Albums", referencedColumnName = "id")
    private Albums albums;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Band", referencedColumnName = "id")
    private Bands band;

    public Songs() {
    }

    public Songs(String title, int yearOfCreation, String genre, int lengthOfSong, float averangeRateOfSong, Albums albums) {
        Title = title;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }



}
