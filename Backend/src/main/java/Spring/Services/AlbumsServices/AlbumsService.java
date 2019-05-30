package Spring.Services.AlbumsServices;

import Spring.Entities.Albums;

public interface AlbumsService {

    Albums getById(Integer id);
    Albums save(Albums album);
    void delete(Integer id);

    Iterable<Albums> getByAlbumName(String albumName);
    Iterable<Albums> getAlbumsWithLowerOrEqualAverageRate(float averageRateOfAlbum);
    Iterable<Albums> getAlbumsWithHigherOrEqualAverageRate(float averageRateOfAlbum);

    Iterable<Albums> listAlbums();

}
