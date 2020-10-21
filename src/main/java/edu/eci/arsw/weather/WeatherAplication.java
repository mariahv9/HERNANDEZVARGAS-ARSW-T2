package edu.eci.arsw.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class that implements the springboot aplication
 * @author Maria Fernanda Hernandez Vargas
 */
@SpringBootApplication
public class WeatherAplication {

    /**
     * Method that executes the aplication on port 8080
     * @param args
     */
    public static void main (String[] args) {
        SpringApplication.run (WeatherAplication.class, args);
    }
}