package edu.eci.arsw.weather.api;

import edu.eci.arsw.weather.service.WeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that implements the aplication controller
 * @author Maria Fernanda Hernandez Vargas
 */
@RestController
@RequestMapping (value = "/weather")
public class WeatherController {

    @Autowired
    WeatherService coronavirusService;


    /**
     * Information by name of the api on the path /{nameCountry}
     * @param name
     * @return
     */
    @RequestMapping (path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllByName (@PathVariable("name") String name){
        try {
            JSONObject jsonObject = coronavirusService.getAllByName(name);
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Information about country coordinates
     * @param name
     * @return
     */
    @RequestMapping (path = "/coordinates/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getCoordinates (@PathVariable("name") String name){
        try {
            JSONObject jsonObject = coronavirusService.getCoordinatesByName(name);
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}