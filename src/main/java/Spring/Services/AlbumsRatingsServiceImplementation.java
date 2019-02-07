package Spring.Services;

import Spring.Entities.AlbumsRatings;
import Spring.Entities.Albums;
import Spring.Repositories.AlbumsRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumsRatingsServiceImplementation implements AlbumsRatingsService {

    @Autowired
    private AlbumsRatingsRepository AlbumsRatingsRepository;

    @Override
    public AlbumsRatings save(AlbumsRatings albumRating){
        return AlbumsRatingsRepository.save(albumRating);
    }

    @Override
    public void delete(Integer id){
        AlbumsRatingsRepository.delete(id);
    }

    @Override
    public Iterable<AlbumsRatings> averangeRating(Albums album){ return AlbumsRatingsRepository.averangeRating(album);}
}

