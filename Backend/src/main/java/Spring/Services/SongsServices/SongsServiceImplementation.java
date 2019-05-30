package Spring.Services.SongsServices;

import Spring.Entities.Songs;
import Spring.Repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongsServiceImplementation implements SongsService {

    @Autowired
    private SongsRepository songsRepository;

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
    public Iterable<Songs> listSongs(){
        return songsRepository.findAll();
    }

    @Override
    public Iterable<Songs> getBySongName(String songName){
        return songsRepository.findBySongName(songName);
    }


}