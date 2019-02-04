package Spring.Services.SongsServices;

import Spring.Entities.Songs;

public interface SongsService {

    Songs getById(Integer id);
    Songs save(Songs song);
    void delete(Integer id);
    Iterable<Songs> listSongs();


}
