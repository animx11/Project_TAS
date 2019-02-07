package Spring.Services;

import Spring.Entities.SongsRatings;
import Spring.Entities.Songs;
import Spring.Repositories.SongsRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongsRatingsServiceImplementation implements SongsRatingsService {

    @Autowired
    private SongsRatingsRepository SongsRatingsRepository;

    @Override
    public SongsRatings save(SongsRatings songRating){
        return SongsRatingsRepository.save(songRating);
    }

    @Override
    public void delete(Integer id){
        SongsRatingsRepository.delete(id);
    }

    @Override
    public Iterable<SongsRatings> averangeRating(Songs song){ return SongsRatingsRepository.averangeRating(song);}
}
