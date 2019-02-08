package Spring.Services;

import Spring.Entities.Songs;

public interface SongsService {

    Songs getById(Integer id);
    Songs save(Songs album);
    void delete(Integer id);

    Iterable<Songs> getByTitle(String title);
    Iterable<Songs> sortSongsByRating();
    Iterable<Songs> getSongsWithLowerOrEqualAverangeRate(float averangeRateOfSongs);
    Iterable<Songs> getSongsWithHigherOrEqualAverangeRate(float averangeRateOfSongs);

    Iterable<Songs> listSongs();

}
