package Spring.Services;

import Spring.Entities.AlbumsComments;

public interface AlbumsCommentsService {

    AlbumsComments save(AlbumsComments albumComment);
    void delete(Integer id);

}
