package Spring.Services;

import Spring.Entities.Songs;

public interface SongsService {

    Songs getById(Integer id);
    Songs save(Songs song);
    void delete(Integer id);

    Iterable<Songs> getBySongsName(String songName);
    Iterable<Songs> getSongsWithLowerOrEqualAverangeRate(float averangeRateOfSongs);
    Iterable<Songs> getSongsWithHigherOrEqualAverangeRate(float averangeRateOfSongs);

    Iterable<Songs> listSongs();

}
