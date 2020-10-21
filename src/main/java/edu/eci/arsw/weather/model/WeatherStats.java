package edu.eci.arsw.weather.model;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class that implements the aplication cache
 * @author Maria Fernanda Hernandez Vargas
 */
@Service ("stats")
public class WeatherStats {
    private ConcurrentHashMap<String, JSONObject> countries = new ConcurrentHashMap<>();

    /**
     * Method that returns save information about covid by name
     * @param name
     * @return
     */
    public JSONObject getAllByName (String name){
        if (countries.containsKey(name)){
            return countries.get(name);
        }else {
            return null;
        }
    }


    /**
     * Method that saves the information by name on cache
     * 5 minutes live on cache
     * @param name
     * @param jsonObject
     */
    public void addByName (final String name, JSONObject jsonObject){
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                countries.remove(name);
                timer.cancel();
            }
        };
        countries.put(name, jsonObject);
        timer.schedule(timerTask, 300000, 1);
    }
}