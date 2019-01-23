package Spring.Services;

import Spring.Entities.BandsRatings;
import Spring.Repositories.BandsRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandsRatingsServiceImplementation implements BandsRatingsService {

    @Autowired
    private BandsRatingsRepository BandsRatingsRepository;

    @Override
    public BandsRatings save(BandsRatings bandRating){
        return BandsRatingsRepository.save(bandRating);
    }

    @Override
    public void delete(Integer id){
        BandsRatingsRepository.delete(id);
    }
}
