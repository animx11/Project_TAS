package Spring.Services;

import Spring.Entities.AlbumsRatings;

public interface AlbumsRatingsService {

    AlbumsRatings save(AlbumsRatings albumRating);
    void delete(Integer id);

}

