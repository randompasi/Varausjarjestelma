package fi.antti.varaus.repository;


import fi.antti.varaus.model.Event;
import org.springframework.data.jpa.repository.*;

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
