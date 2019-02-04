package Spring.Services.MusiciansServices;

import Spring.Entities.Musicians;
import Spring.Repositories.MusiciansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusiciansServicesImplementation implements MusiciansService {


    @Autowired
    private MusiciansRepository musiciansRepository;

    @Override
    public Musicians getById(Integer id){
        return musiciansRepository.findOne(id);
    }

    @Override
    public Musicians save(Musicians musician){
        return musiciansRepository.save(musician);
    }

    @Override
    public void delete(Integer id){
        musiciansRepository.delete(id);
    }

    @Override
    public Iterable<Musicians> listMusicians(){
        return musiciansRepository.findAll();
    }

    @Override
    public Iterable<Musicians> getMusiciansByFirstName(String firstName){
        return musiciansRepository.findMusiciansByFirstName(firstName);
    }

    @Override
    public Iterable<Musicians> getMusiciansByLastName(String lastName){
        return musiciansRepository.findMusiciansByLastName(lastName);
    }

    @Override
    public Iterable<Musicians> getMusiciansByPseudonym(String pseudonym){
        return musiciansRepository.findMusiciansByPseudonym(pseudonym);
    }
    @Override
    public Iterable<Musicians> getMusiciansByBandName(String bandName){
        return musiciansRepository.findMusiciansByBandName(bandName);
    }
}
