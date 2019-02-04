package Spring.Controllers;

import Spring.Entities.Albums;
import Spring.Services.AlbumsService;
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
public class AlbumsController {

    @Autowired
    private AlbumsService albumsService;

    @RequestMapping(value = "/albums", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Albums> listAlbums(){
        return albumsService.listAlbums();
    }

    @RequestMapping(value = "albums_by_id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Albums getByParamId(@RequestParam("id") Integer id){
        return albumsService.getById(id);
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Albums getByPublicId(@PathVariable("id") Integer id){
        return albumsService.getById(id);
    }

    @RequestMapping(value = "/albums", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Albums> create(@RequestBody @Valid @NotNull Albums album) {
        if (!albumsService.getByAlbumName(album.getAlbumName()).iterator().hasNext()) {
            albumsService.save(album);
            return ResponseEntity.ok().body(album);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @RequestMapping(value = "/albums", method = RequestMethod.PUT)
    public ResponseEntity<Albums> edit(@RequestBody @Valid @NotNull Albums album){
        Albums editAlbum = albumsService.getById(album.getId());
        if(Objects.nonNull(editAlbum)){
            albumsService.save(album);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/albums", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Albums> delete(@PathVariable Integer id){
        albumsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/albums_by_albumName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Albums> getByAlbumName(@RequestParam("albumName") String albumName){
        return albumsService.getByAlbumName(albumName);
    }

    @RequestMapping(value = "/albums_LOEAverangeRate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Albums>  getAlbumsWithHLowerOrEqualAverangeRate(@RequestParam("averangeRateOfAlbum") float averangeRateOfAlbum){
        return albumsService.getAlbumsWithLowerOrEqualAverangeRate(averangeRateOfAlbum);
    }

    @RequestMapping(value = "/albums_HOEAverangeRate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Albums>  getAlbumsWithHigherOrEqualAverangeRate(@RequestParam("averangeRateOfAlbum") float averangeRateOfAlbum){
        return albumsService.getAlbumsWithHigherOrEqualAverangeRate(averangeRateOfAlbum);
    }

}
