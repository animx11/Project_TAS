package Spring.Services;

import Spring.Entities.Albums;
import Spring.Repositories.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumsServiceImplementation implements AlbumsService {

    @Autowired
    private AlbumsRepository albumsRepository;

    @Override
    public Albums getById(Integer id){
        return albumsRepository.findOne(id);
    }

    @Override
    public Albums save(Albums album){
        return albumsRepository.save(album);
    }

    @Override
    public void delete(Integer id){
        albumsRepository.delete(id);
    }

    @Override
    public Iterable<Albums> getAlbumsPaged(int page){
        return albumsRepository.findAlbumsPaged(page);
    }
    @Override
    public Iterable<Albums> getByAlbumName(String albumName){
        return albumsRepository.findByAlbumName(albumName);
    }

    @Override
    public Iterable<Albums> getAlbumsWithLowerOrEqualAverangeRate(float averangeRateOfAlbum){
        return albumsRepository.findAlbumsWithLowerOrEqualAverangeRate(averangeRateOfAlbum);
    }

    @Override
    public Iterable<Albums> getAlbumsWithHigherOrEqualAverangeRate(float averangeRateOfAlbum){
        return albumsRepository.findAlbumsWithHigherOrEqualAverangeRate(averangeRateOfAlbum);
    }

    @Override
    public Iterable<Albums> listAlbums(){
        return albumsRepository.findAll();
    }

}
