package Spring.Services;

import Spring.Entities.SongsComments;

public interface SongsCommentsService {

    SongsComments save(SongsComments songComment);
    void delete(Integer id);
}
