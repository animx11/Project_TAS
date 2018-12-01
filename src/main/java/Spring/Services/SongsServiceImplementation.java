package Spring.Services;

import Spring.Entities.Songs;
import Spring.Repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongsServiceImplementation implements SongsService {

    @Autowired
    private SongsRepository SongsRepository;

    @Override
    public Songs getById(Integer id){
        return SongsRepository.findOne(id);
    }

    @Override
    public Songs save(Songs song){
        return SongsRepository.save(song);
    }

    @Override
    public void delete(Integer id){
        SongsRepository.delete(id);
    }

    @Override
    public Iterable<Songs> listSongs(){
        return SongsRepository.findAll();
    }


}