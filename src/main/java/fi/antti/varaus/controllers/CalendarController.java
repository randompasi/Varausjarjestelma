package fi.antti.varaus.controllers;

/**
 * Kontrolli luokka kalenterin tapahtumien kutsujen hallintaan
 */

import fi.antti.varaus.model.Event;
import fi.antti.varaus.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class CalendarController {

    @Autowired
    private EventService eventService;

        @GetMapping("/")
        public ModelAndView calendar() {
            return new ModelAndView("sportCalendar");
        }



    @GetMapping(value="/eventsTime")
    public List<Event> getEventsInRange(@RequestParam(value = "start", required = true) String start,
                                        @RequestParam(value = "end", required = true) String end) {
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat inputDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDate = inputDateFormat.parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            endDate = inputDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return eventService.findByDatesBetween(startDate, endDate);
    }


    @PostMapping("/addEvent")
    public Event addEvent(@Valid @RequestBody Event event) {
        return eventService.save(event);
    }

    @PatchMapping("/updateEvent")
    public Event updateEvent(@RequestBody Event event)
    {System.out.println("taaalla");
        return eventService.save(event);
    }

    @DeleteMapping("/removeEvent")
    public void removeEvent(@RequestBody Event event) {

          eventService.delete(event);
    }

    @RequestMapping("/enroll")
    public void enroll(HttpServletRequest request){
        System.out.println(request.getUserPrincipal().getName());
    }

}


