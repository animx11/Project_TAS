package Spring.Controllers;

import Spring.Entities.SongsComments;
import Spring.Services.SongsCommentsService;
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

public class SongsCommentsController {
    @Autowired
    private SongsCommentsService songsCommentsService;

    @RequestMapping(value = "/songscomments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SongsComments> listSongsComments(){
        return songsCommentsService.listSongsComments();
    }

    @RequestMapping(value = "/songscomments", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SongsComments> create(@RequestBody @Valid @NotNull SongsComments songComment){
        songsCommentsService.save(songComment);
        return ResponseEntity.ok().body(songComment);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/songscomments", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SongsComments> delete(@PathVariable Integer id){
        songsCommentsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/songscomments_by_date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SongsComments> sortSongsCommentsByDate(){ return songsCommentsService.sortSongsCommentsByDate();
    }
    @RequestMapping(value = "/songscomments_by_rating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SongsComments> sortSongsCommentsByRating(){ return songsCommentsService.sortSongsCommentsByRating();
    }
}
