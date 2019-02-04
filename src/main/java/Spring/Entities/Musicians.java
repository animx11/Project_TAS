package Spring.Entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Musicans", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class Musicians {



    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_name")
    private String lastName;

    @Column(name = "Pseudonym")
    private String pseudonym;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Band", referencedColumnName = "id")
    private Bands band;

    @Column(name = "Birth_date")
    private Date birthDate;

    @Column(name = "Origin")
    private String origin;

    @Column(name = "Instrument")
    private String instrument;

    @Column(name = "Average_Rate_Of_Album")
    private float averageRateOfAlbum;

    public Musicians() {
    }

    public Musicians(String firstName, String lastName, String pseudonym, Bands band, Date birthDate, String origin, String instrument, float averageRateOfAlbum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudonym = pseudonym;
        this.band = band;
        this.birthDate = birthDate;
        this.origin = origin;
        this.instrument = instrument;
        this.averageRateOfAlbum = averageRateOfAlbum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Bands getBand() {
        return band;
    }

    public void setBand(Bands band) {
        this.band = band;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public float getAverageRateOfAlbum() {
        return averageRateOfAlbum;
    }

    public void setAverageRateOfAlbum(float averageRateOfAlbum) {
        this.averageRateOfAlbum = averageRateOfAlbum;
    }


}
