package fi.antti.varaus.controllers;
import fi.antti.varaus.model.Event;
import fi.antti.varaus.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CalenderController {

    @Autowired
    private EventRepository eventRespository;

        @GetMapping({"/", "/calender"})
        public List<Event> events() {
            return eventRespository.findAll();
        }
@GetMapping("/events")
    public List<Event> getEventsInRange(@RequestParam(value = "start", required = true) String start,
                                        @RequestParam(value = "end", required = true) String end) {
        Date startDate = null;
        java.sql.Date endDate = null;
        SimpleDateFormat inputDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDate = (Date) inputDateFormat.parse(start);
        } catch (ParseException e) {
            System.out.println("bad start date: " + start);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

    try {
            endDate = (Date) inputDateFormat.parse(end);
        } catch (ParseException e) {
            System.out.println("bad end date: " + end);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

    return eventRespository.findByDatesBetween(startDate, endDate);
    }

}


