package Spring.Services;

import Spring.Entities.BandsRatings;
import Spring.Entities.Bands;

public interface BandsRatingsService {

    BandsRatings save(BandsRatings bandRating);
    void delete(Integer id);
    Iterable<BandsRatings> averangeRating(Bands band);

}
