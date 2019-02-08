package Spring.Services;

import Spring.Entities.AlbumsComments;
import Spring.Repositories.AlbumsCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumsCommentsServiceImplementation implements AlbumsCommentsService {

    @Autowired
    private AlbumsCommentsRepository AlbumsCommentsRepository;

    @Override
    public AlbumsComments save(AlbumsComments albumComment){
        return AlbumsCommentsRepository.save(albumComment);
    }

    @Override
    public void delete(Integer id){
        AlbumsCommentsRepository.delete(id);
    }

    @Override
    public Iterable<AlbumsComments> listAlbumsComments(){
        return AlbumsCommentsRepository.findAll();
    }

    @Override
    public Iterable<AlbumsComments> sortAlbumsCommentsByDate() {return AlbumsCommentsRepository.sortAlbumsCommentsByDate();}

    @Override
    public Iterable<AlbumsComments> sortAlbumsCommentsByRating() {return AlbumsCommentsRepository.sortAlbumsCommentsByRating();}

    @Override
    public Iterable<AlbumsComments> upvoteAlbumComment(Integer id) {return AlbumsCommentsRepository.upvoteAlbumComment(id);}

    @Override
    public Iterable<AlbumsComments> downvoteAlbumComment(Integer id) {return AlbumsCommentsRepository.downvoteAlbumComment(id);}
 }
