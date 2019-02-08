package Spring.Controllers;

import Spring.Entities.BandsRatings;
import Spring.Entities.Bands;
import Spring.Services.BandsRatingsService;
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

public class BandsRatingsController {

    @Autowired
    private BandsRatingsService bandsRatingsService;

    @RequestMapping(value = "/bandsratings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BandsRatings> create(@RequestBody @Valid @NotNull BandsRatings bandRating){
        bandsRatingsService.save(bandRating);
        return ResponseEntity.ok().body(bandRating);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/bandsratings", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BandsRatings> delete(@PathVariable Integer id){
        bandsRatingsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/averangeBandRating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BandsRatings> averangeRating(@RequestParam("band") Bands band){
        return bandsRatingsService.averangeRating(band);
    }
}
