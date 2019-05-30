package Spring.Services.AlbumsServices;

import Spring.Entities.Albums;
import Spring.Repositories.AlbumsRepository;
import Spring.Services.AlbumsServices.AlbumsService;
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
    public Iterable<Albums> getByAlbumName(String albumName){
        return albumsRepository.findByAlbumName(albumName);
    }

    @Override
    public Iterable<Albums> getAlbumsWithLowerOrEqualAverageRate(float averageRateOfAlbum){
        return albumsRepository.findAlbumsWithLowerOrEqualAverageRate(averageRateOfAlbum);
    }

    @Override
    public Iterable<Albums> getAlbumsWithHigherOrEqualAverageRate(float averageRateOfAlbum){
        return albumsRepository.findAlbumsWithHigherOrEqualAverageRate(averageRateOfAlbum);
    }

    @Override
    public Iterable<Albums> listAlbums(){
        return albumsRepository.findAll();
    }

}
