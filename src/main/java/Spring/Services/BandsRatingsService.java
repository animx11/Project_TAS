package Spring.Services;

import Spring.Entities.BandsRatings;

public interface BandsRatingsService {

    BandsRatings save(BandsRatings bandRating);
    void delete(Integer id);

}
