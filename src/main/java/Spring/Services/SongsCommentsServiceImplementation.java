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

    @Override
    public Iterable<SongsComments> listSongsComments(){
        return SongsCommentsRepository.findAll();
    }

    @Override
    public Iterable<SongsComments> sortSongsCommentsByDate() {return SongsCommentsRepository.sortSongsCommentsByDate();}

    @Override
    public Iterable<SongsComments> sortSongsCommentsByRating() {return SongsCommentsRepository.sortSongsCommentsByRating();}
}
