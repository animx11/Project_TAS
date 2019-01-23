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
}
