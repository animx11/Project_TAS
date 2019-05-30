package Spring.Entities;

import javax.persistence.*;


@Entity
@Table(name = "Bands", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
public class Bands {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "Band_Name" , unique = true)
    private String bandName;

    @Column(name = "Year_of_creation")
    private int yearOfCreation;

    @Column(name = "Origin")
    private String origin;

    @Column(name = "Average_Rate_Of_Band")
    private float averageRateOfBand;

    public Bands() {
    }

    public Bands(String bandName, int yearOfCreation, String origin, float averangeRateOfBand) {
        this.bandName = bandName;
        this.yearOfCreation = yearOfCreation;
        this.origin = origin;
        this.averageRateOfBand = averangeRateOfBand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setName(String bandName) {
        this.bandName = bandName;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getAverangeRateOfBand() {
        return averageRateOfBand;
    }

    public void setAverangeRateOfBand(float averangeRateOfBand) {
        this.averageRateOfBand = averangeRateOfBand;
    }


}
