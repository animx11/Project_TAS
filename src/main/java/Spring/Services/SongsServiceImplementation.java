package Spring.Services;

import Spring.Entities.Songs;
import Spring.Repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongsServiceImplementation implements SongsService {

    private final SongsRepository songsRepository;

    @Autowired
    public SongsServiceImplementation(SongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    @Override
    public Songs getById(Integer id){
        return songsRepository.findOne(id);
    }

    @Override
    public Songs save(Songs song){
        return songsRepository.save(song);
    }

    @Override
    public void delete(Integer id){
        songsRepository.delete(id);
    }


    @Override
    public Iterable<Songs> getBySongsName(String songsName){
        return songsRepository.findBySongName(songsName);
    }

    @Override
    public Iterable<Songs> getSongsWithLowerOrEqualAverangeRate(float averangeRateOfSong){
        return songsRepository.findSongsWithLowerOrEqualAverangeRate(averangeRateOfSong);
    }

    @Override
    public Iterable<Songs> getSongsWithHigherOrEqualAverangeRate(float averangeRateOfSong){
        return songsRepository.findSongsWithHigherOrEqualAverangeRate(averangeRateOfSong);
    }

    @Override
    public Iterable<Songs> listSongs(){
        return songsRepository.findAll();
    }

}
