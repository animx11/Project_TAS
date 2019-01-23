package Spring.Services;

import Spring.Entities.SongsComments;
import Spring.Repositories.SongsCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongsCommentsServiceImplementation implements SongsCommentsService {

    @Autowired
    private SongsCommentsRepository SongsCommentsRepository;

    @Override
    public SongsComments save(SongsComments songComment){
        return SongsCommentsRepository.save(songComment);
    }

    @Override
    public void delete(Integer id){
        SongsCommentsRepository.delete(id);
    }
}
