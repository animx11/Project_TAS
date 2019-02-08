package Spring.Controllers;

import Spring.Entities.SongsRatings;
import Spring.Entities.Songs;
import Spring.Services.SongsRatingsService;
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

public class SongsRatingsController {

    @Autowired
    private SongsRatingsService songsRatingsService;

    @RequestMapping(value = "/songsratings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SongsRatings> create(@RequestBody @Valid @NotNull SongsRatings songRating){
        songsRatingsService.save(songRating);
        return ResponseEntity.ok().body(songRating);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/songsratings", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SongsRatings> delete(@PathVariable Integer id){
        songsRatingsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/averangeSongRating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SongsRatings> averangeRating(@RequestParam("song") Songs song){
        return songsRatingsService.averangeRating(song);
    }
}
