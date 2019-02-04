package Spring.Controllers;


import Spring.Entities.Songs;
import Spring.Services.SongsServices.SongsService;
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

public class SongsController {


    @Autowired
    private SongsService songsService;

    @RequestMapping(value = "/songs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Songs> listSongs(){
        return songsService.listSongs();
    }

    @RequestMapping(value = "songs_by_id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Songs getByParamId(@RequestParam("id") Integer id){
        return songsService.getById(id);
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Songs getByPublicId(@PathVariable("id") Integer id){
        return songsService.getById(id);
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Songs> create(@RequestBody @Valid @NotNull Songs song) {
        if (!songsService.getBySongName(song.getSongName()).iterator().hasNext()) {
            songsService.save(song);
            return ResponseEntity.ok().body(song);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @RequestMapping(value = "/songs", method = RequestMethod.PUT)
    public ResponseEntity<Songs> edit(@RequestBody @Valid @NotNull Songs song){
        Songs editSong = songsService.getById(song.getId());
        if(Objects.nonNull(editSong)){
            songsService.save(song);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/songs", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Songs> delete(@PathVariable Integer id){
        songsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/song_by_songName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Songs> getBySongName(@RequestParam("songName") String songName){
        return songsService.getBySongName(songName);
    }


}
