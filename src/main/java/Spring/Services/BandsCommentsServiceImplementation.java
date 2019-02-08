package Spring.Services;

import Spring.Entities.BandsComments;
import Spring.Repositories.BandsCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandsCommentsServiceImplementation implements BandsCommentsService{

    @Autowired
    private BandsCommentsRepository BandsCommentsRepository;

    @Override
    public BandsComments save(BandsComments bandComment){
        return BandsCommentsRepository.save(bandComment);
    }

    @Override
    public void delete(Integer id){
        BandsCommentsRepository.delete(id);
    }

    @Override
    public Iterable<BandsComments> listBandsComments(){
        return BandsCommentsRepository.findAll();
    }

    @Override
    public Iterable<BandsComments> sortBandsCommentsByDate() {return BandsCommentsRepository.sortBandsCommentsByDate();}

    @Override
    public Iterable<BandsComments> sortBandsCommentsByRating() {return BandsCommentsRepository.sortBandsCommentsByRating();}
}
