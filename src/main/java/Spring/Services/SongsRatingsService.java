package Spring.Services;

import Spring.Entities.SongsRatings;

public interface SongsRatingsService {

    SongsRatings save(SongsRatings songRating);
    void delete(Integer id);
}
