package Spring.Services.BandsServices;

import Spring.Entities.Bands;

public interface BandsService {

    Bands getById(Integer id);
    Bands save(Bands band);
    void delete(Integer id);

    Iterable<Bands> getByBandName(String bandName);
    Iterable<Bands> getBandsWithLowerOrEqualAverageRate(float averaneRateOfBand);
    Iterable<Bands> getBandsWithHigherOrEqualAverageRate(float averaneRateOfBand);

    Iterable<Bands> listBands();
}
