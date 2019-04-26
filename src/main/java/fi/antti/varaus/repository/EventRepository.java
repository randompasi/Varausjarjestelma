package fi.antti.varaus.repository;

/**
 * interface jonka avulla spring luo ohjelman aikana tietokannan Evnteille elikka liikuntatunneille
 * samalla maaritetaan kysymykset mita voi tehda tietokantaan
 */

import fi.antti.varaus.model.Event;
import fi.antti.varaus.model.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
        List<Event> findAll();
    Event save(Event event);
    void delete(Event event);
    @Query("select b from Event b " +
            "where b.start between ?1 and ?2 and b.end between ?1 and ?2")
    List<Event> findByDatesBetween(Date start, Date end);
}
