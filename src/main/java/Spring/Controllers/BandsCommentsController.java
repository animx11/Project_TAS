package Spring.Controllers;

import Spring.Entities.BandsComments;
import Spring.Services.BandsCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.Objects;

@RestController
@RequestMapping("/api")


public class BandsCommentsController {

    @Autowired
    private BandsCommentsService bandsCommentsService;

    @RequestMapping(value = "/bandscomments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BandsComments> listBandsComments(){
        return bandsCommentsService.listBandsComments();
    }

    @RequestMapping(value = "/bandscomments", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BandsComments> create(@RequestBody @Valid @NotNull BandsComments bandComment){
        bandsCommentsService.save(bandComment);
        return ResponseEntity.ok().body(bandComment);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/bandscomments", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BandsComments> delete(@PathVariable Integer id){
        bandsCommentsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/bandscomments_by_date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BandsComments> sortBandsCommentsByDate(){ return bandsCommentsService.sortBandsCommentsByDate();
    }
    @RequestMapping(value = "/bandscomments_by_rating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BandsComments> sortBandsCommentsByRating(){ return bandsCommentsService.sortBandsCommentsByRating();
    }

}
