package fi.antti.varaus.service;

import fi.antti.varaus.model.Event;
import fi.antti.varaus.model.User;

import java.util.Date;
import java.util.List;

public interface EventService {
    boolean isEnrollmentFull(Event event);
  //  void enrollUser(User user, Long eventID);
    Event save(Event event);
    void delete(Event event);
    List<Event> findByDatesBetween(Date start, Date end);

}

