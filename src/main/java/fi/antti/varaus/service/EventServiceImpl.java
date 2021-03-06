package fi.antti.varaus.service;

import fi.antti.varaus.model.Event;
import fi.antti.varaus.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepository eventRepository;

    public boolean isEnrollmentFull(Event event){
        return event.getUsers().size() >= event.getParticipantLimit();
    }


    @Override
    public Event save(Event event) {

       Set<String> filtered =  event.getUsers().stream().filter(value -> value != null || value != " ").collect(Collectors.toSet());
       event.setUsers(filtered);
        return eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);

    }

    public void enrollUser(String username, Event event){
        Optional<Event> updated = eventRepository.findById(event.getId());
        Set<String> booked = updated.get().getUsers();
        booked.add(username);
        updated.get().setUsers(booked);
        System.out.println(updated.get().getUsers().size());
          eventRepository.save(updated.get());
    }

    public List<Event> findByDatesBetween(Date start, Date end){
        List<Event> a =eventRepository.findByDatesBetween(start, end);

        for(Event x : a){
           Set<String> s =  x.getUsers().stream().filter(value -> value != "" ).collect(Collectors.toSet());
           x.setUsers(s);
        }
        return eventRepository.findByDatesBetween(start, end);
    }




}
