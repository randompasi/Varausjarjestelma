package fi.antti.varaus.service;

import fi.antti.varaus.model.Event;
import fi.antti.varaus.model.User;
import fi.antti.varaus.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepository eventRepository;

    public boolean isEnrollmentFull(Event event){
        return event.getUsers().size() >= event.getEnrollLimit();
    }


    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);

    }

    public void enrollUser(User user, Long eventID){
        Optional<Event> event = eventRepository.findById(eventID);
        event.get().getUsers().add(user);
          eventRepository.save(event.get());
    }

    public List<Event> findByDatesBetween(Date start, Date end){
        return eventRepository.findByDatesBetween(start, end);
    }




}
