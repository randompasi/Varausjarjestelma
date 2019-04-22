package fi.antti.varaus;
/**
 * Spring applicaation kaynnistys
 * Kerrotaan Springille mista aloittaa ohjelma
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}