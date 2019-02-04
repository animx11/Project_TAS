package Spring.Services.BandsServices;

import Spring.Entities.Bands;
import Spring.Repositories.BandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandsServiceImplementation implements BandsService {

    @Autowired
    private BandsRepository bandsRepository;

    @Override
    public Bands getById(Integer id){ return bandsRepository.findById(id); }

    @Override
    public Bands save(Bands band){
        return bandsRepository.save(band);
    }

    @Override
    public void delete(Integer id){
        bandsRepository.delete(id);
    }


    @Override
    public Iterable<Bands> getByBandName(String bandName){
        return bandsRepository.findByBandName(bandName);
    }

    @Override
    public Iterable<Bands> getBandsWithLowerOrEqualAverageRate(float averageRateOfBand){
        return bandsRepository.findBandsWithLowerOrEqualAverageRate(averageRateOfBand);
    }

    @Override
    public Iterable<Bands> getBandsWithHigherOrEqualAverageRate(float averageRateOfBand){
        return bandsRepository.findBandsWithHigherOrEqualAverageRate(averageRateOfBand);
    }

    @Override
    public Iterable<Bands> listBands(){
        return bandsRepository.findAll();
    }

}
