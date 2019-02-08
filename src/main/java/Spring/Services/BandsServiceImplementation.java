package Spring.Services;

import Spring.Entities.Bands;
import Spring.Repositories.BandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandsServiceImplementation implements BandsService {

    @Autowired
    private BandsRepository bandsRepository;

    @Override
    public Bands getById(Integer id){
        return bandsRepository.findOne(id);
    }

    @Override
    public Bands save(Bands album){
        return bandsRepository.save(album);
    }

    @Override
    public void delete(Integer id){
        bandsRepository.delete(id);
    }


    @Override
    public Iterable<Bands> getByBandName(String name){
        return bandsRepository.findByBandName(name);
    }

    @Override
    public Iterable<Bands> sortBandsByRating() {return bandsRepository.sortBandsByRating();}

    @Override
    public Iterable<Bands> getBandsWithLowerOrEqualAverangeRate(float averangeRateOfBand){
        return bandsRepository.findBandsWithLowerOrEqualAverangeRate(averangeRateOfBand);
    }

    @Override
    public Iterable<Bands> getBandsWithHigherOrEqualAverangeRate(float averangeRateOfBand){
        return bandsRepository.findBandsWithHigherOrEqualAverangeRate(averangeRateOfBand);
    }

    @Override
    public Iterable<Bands> listBands(){
        return bandsRepository.findAll();
    }

}