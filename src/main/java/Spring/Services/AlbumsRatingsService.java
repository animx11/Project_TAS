package Spring.Services;

import Spring.Entities.AlbumsRatings;
import Spring.Entities.Albums;

public interface AlbumsRatingsService {

    AlbumsRatings save(AlbumsRatings albumRating);
    void delete(Integer id);
    Iterable<AlbumsRatings> averangeRating(Albums album);
}

