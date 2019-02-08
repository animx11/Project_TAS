package Spring.Services;

import Spring.Entities.SongsRatings;
import Spring.Entities.Songs;

public interface SongsRatingsService {

    SongsRatings save(SongsRatings songRating);
    void delete(Integer id);
    Iterable<SongsRatings> averangeRating(Songs song);
}
