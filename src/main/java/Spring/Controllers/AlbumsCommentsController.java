package Spring.Controllers;

import Spring.Entities.AlbumsComments;
import Spring.Services.AlbumsCommentsService;
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

public class AlbumsCommentsController {

    @Autowired
    private AlbumsCommentsService albumsCommentsService;

    @RequestMapping(value = "/albumscomments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AlbumsComments> listAlbumsComments(){
        return albumsCommentsService.listAlbumsComments();
    }

    @RequestMapping(value = "/albumscomments", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumsComments> create(@RequestBody @Valid @NotNull AlbumsComments albumComment){
        albumsCommentsService.save(albumComment);
        return ResponseEntity.ok().body(albumComment);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/albumscomments", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumsComments> delete(@PathVariable Integer id){
        albumsCommentsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/albumscomments_by_date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AlbumsComments> sortAlbumsCommentsByDate(){ return albumsCommentsService.sortAlbumsCommentsByDate();
    }
    @RequestMapping(value = "/albumscomments_by_rating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AlbumsComments> sortAlbumsCommentsByRating(){ return albumsCommentsService.sortAlbumsCommentsByRating();
    }
    @RequestMapping(value = "/albumcommentupvote", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AlbumsComments> upvoteAlbumComment(@RequestParam("id") Integer id){return albumsCommentsService.upvoteAlbumComment(id);
    }
    @RequestMapping(value = "/albumcommentdownvote", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AlbumsComments> downvoteAlbumComment(@RequestParam("id") Integer id){return albumsCommentsService.downvoteAlbumComment(id);
    }
}
