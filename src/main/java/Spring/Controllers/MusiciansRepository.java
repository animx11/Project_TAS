package Spring.Controllers;

import Spring.Entities.Musicians;
import Spring.Services.MusiciansServices.MusiciansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class MusiciansRepository {

    @Autowired
    MusiciansService musiciansService;


    @RequestMapping(value = "/musicians", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Musicians> listMusicians(){
        return musiciansService.listMusicians();
    }

    @RequestMapping(value = "musicians_by_id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Musicians getByParamId(@RequestParam("id") Integer id){
        return musiciansService.getById(id);
    }

    @RequestMapping(value = "/musicians/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Musicians getByPublicId(@PathVariable("id") Integer id){
        return musiciansService.getById(id);
    }

    @RequestMapping(value = "/musicians", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Musicians> create(@RequestBody @Valid @NotNull Musicians musicians) {
            musiciansService.save(musicians);
            return ResponseEntity.ok().body(musicians);
    }

    @RequestMapping(value = "/musicians", method = RequestMethod.PUT)
    public ResponseEntity<Musicians> edit(@RequestBody @Valid @NotNull Musicians musicians){
        Musicians editBand = musiciansService.getById(musicians.getId());
        if(Objects.nonNull(editBand)){
            musiciansService.save(musicians);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/musicians", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Musicians> delete(@PathVariable Integer id){
        musiciansService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/musicians_by_firstName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Musicians> getMusiciansByFirstName(@RequestParam("firstName") String firstName){
        return musiciansService.getMusiciansByFirstName(firstName);
    }
    @RequestMapping(value = "/musicians_by_lastName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Musicians> getMusiciansByLastName(@RequestParam("lastName") String lastName){
        return musiciansService.getMusiciansByLastName(lastName);
    }

    @RequestMapping(value = "/musicians_by_pseudonym", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Musicians> getMusiciansByPseudonym(@RequestParam("pseudonym") String pseudonym){
        return musiciansService.getMusiciansByPseudonym(pseudonym);
    }

    @RequestMapping(value = "/musicians_by_bandName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Musicians> getMusiciansByBandName(@RequestParam("bandName") String bandName){
        return musiciansService.getMusiciansByBandName(bandName);
    }

}
