package Spring.Services;

import Spring.Entities.Bands;

public interface BandsService {
    Bands getById(Integer id);
    Bands save(Bands band);
    void delete(Integer id);

    Iterable<Bands> getByBandName(String name);
    Iterable<Bands> sortBandsByRating();
    Iterable<Bands> getBandsWithLowerOrEqualAverangeRate(float averangeRateOfBand);
    Iterable<Bands> getBandsWithHigherOrEqualAverangeRate(float averangeRateOfBand);

    Iterable<Bands> listBands();

}
