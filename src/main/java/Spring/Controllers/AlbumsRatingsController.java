package Spring.Controllers;

import Spring.Entities.AlbumsRatings;
import Spring.Services.AlbumsRatingsService;
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

public class AlbumsRatingsController {

    @Autowired
    private AlbumsRatingsService albumsRatingsService;

    @RequestMapping(value = "/albumsratings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumsRatings> create(@RequestBody @Valid @NotNull AlbumsRatings albumRating){
        albumsRatingsService.save(albumRating);
        return ResponseEntity.ok().body(albumRating);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/albumsratings", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumsRatings> delete(@PathVariable Integer id){
        albumsRatingsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
