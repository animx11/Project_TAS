package Spring.Services.MusiciansServices;

import Spring.Entities.Musicians;

public interface MusiciansService {

    Musicians getById(Integer id);
    Musicians save(Musicians musician);
    void delete(Integer id);

    Iterable<Musicians> getMusiciansByFirstName(String firstName);
    Iterable<Musicians> getMusiciansByLastName(String lastName);
    Iterable<Musicians> getMusiciansByPseudonym(String pseudonym);
    Iterable<Musicians> getMusiciansByBandName(String bandName);
    Iterable<Musicians> listMusicians();

}
