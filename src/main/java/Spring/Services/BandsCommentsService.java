package Spring.Services;

import Spring.Entities.BandsComments;

public interface BandsCommentsService {

    BandsComments save(BandsComments bandComment);
    void delete(Integer id);
    Iterable<BandsComments> listBandsComments();
    Iterable<BandsComments> sortBandsCommentsByDate();
    Iterable<BandsComments> sortBandsCommentsByRating();

}

