package Spring.Controllers;

import Spring.Entities.Bands;
import Spring.Services.BandsService;
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
public class BandsController {

    @Autowired
    private BandsService bandsService;

    @RequestMapping(value = "/bands", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Bands> listBands(){ return bandsService.listBands();
    }

    @RequestMapping(value = "bands_by_id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Bands getByParamId(@RequestParam("id") Integer id){
        return bandsService.getById(id);
    }

    @RequestMapping(value = "/bands/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Bands getByPublicId(@PathVariable("id") Integer id){
        return bandsService.getById(id);
    }

    @RequestMapping(value = "/bands", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bands> create(@RequestBody @Valid @NotNull Bands band){
        bandsService.save(band);
        return ResponseEntity.ok().body(band);
    }

    @RequestMapping(value = "/bands", method = RequestMethod.PUT)
    public ResponseEntity<Bands> edit(@RequestBody @Valid @NotNull Bands band){
        Bands editBand = bandsService.getById(band.getId());
        if(Objects.nonNull(editBand)){
            bandsService.save(band);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/bands", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bands> delete(@PathVariable Integer id){
        bandsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/bands_by_albumName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Bands> getByBandName(@RequestParam("name") String name){
        return bandsService.getByBandName(name);
    }

    @RequestMapping(value = "/bands_by_rating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Bands> sortBandsByRating(){ return bandsService.sortBandsByRating();
    }

    @RequestMapping(value = "/bands_LOEAverangeRate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Bands>  getBandsWithHLowerOrEqualAverangeRate(@RequestParam("averangeRateOfBand") float averangeRateOfBand){
        return bandsService.getBandsWithLowerOrEqualAverangeRate(averangeRateOfBand);
    }

    @RequestMapping(value = "/bands_HOEAverangeRate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Bands>  getBandsWithHigherOrEqualAverangeRate(@RequestParam("averangeRateOfBand") float averangeRateOfBand){
        return bandsService.getBandsWithHigherOrEqualAverangeRate(averangeRateOfBand);
    }
}
