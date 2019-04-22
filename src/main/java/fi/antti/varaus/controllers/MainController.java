package fi.antti.varaus.controllers;

/**
 * Kontrolli luokka pää tapahtumille tässä tapauksessa vain kirjautumiselle
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
