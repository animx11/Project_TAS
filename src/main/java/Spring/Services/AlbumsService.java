package Spring.Services;

import Spring.Entities.Albums;

public interface AlbumsService {

    Albums getById(Integer id);
    Albums save(Albums album);
    void delete(Integer id);

    Iterable<Albums> getByAlbumName(String albumName);
    Iterable<Albums> sortAlbumsByRating();
    Iterable<Albums> getAlbumsWithLowerOrEqualAverangeRate(float averangeRateOfAlbum);
    Iterable<Albums> getAlbumsWithHigherOrEqualAverangeRate(float averangeRateOfAlbum);

    Iterable<Albums> listAlbums();

}
