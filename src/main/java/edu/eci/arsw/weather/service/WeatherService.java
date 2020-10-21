package edu.eci.arsw.weather.service;

import edu.eci.arsw.weather.model.WeatherStats;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class that implements aplication service and obtains JSON information
 * @author Maria Fernanda Hernandez Vargas
 */
@Service("coronavirus")
public class WeatherService {

    @Autowired
    HTTPConnection httpConnection;

    @Autowired
    WeatherStats stats;

    /**
     * Method that return JSON information by country name
     * @param name
     * @return
     * @throws WeatherException
     */
    public JSONObject getAllByName (String name) throws WeatherException {
        JSONObject jsonObject = stats.getAllByName(name);
        if (jsonObject != null){
            return jsonObject;
        } else {
            JSONObject object = httpConnection.getAllByName(name);
            stats.addByName(name, object);
            return object;
        }
    }

    /**
     * Method that returns JSON country coordinates
     * @param name
     * @return
     * @throws WeatherException
     */
    public JSONObject getCoordinatesByName(String name) throws WeatherException {
        JSONObject jsonObject = stats.getAllByName(name);
        if (jsonObject != null) {
            JSONArray coordinates = new JSONArray("["+jsonObject.get("coord")+"]");
            double lon = coordinates.getJSONObject(0).getDouble("lon");
            double lat = coordinates.getJSONObject(0).getDouble("lat");
            JSONObject jsonObject1 = new JSONObject("{\"latitude\":\""+lat+"\",\"longitude\":\""+lon+"\"}");
            return jsonObject1;
        } else {
            JSONObject js = httpConnection.getAllByName(name);
            JSONArray coordinates = new JSONArray("["+js.get("coord")+"]");
            double lon = coordinates.getJSONObject(0).getDouble("lon");
            double lat = coordinates.getJSONObject(0).getDouble("lat");
            JSONObject jsonObject1 = new JSONObject("{\"latitude\":\""+lat+"\",\"longitude\":\""+lon+"\"}");
            stats.addByName(name, jsonObject1);
            return jsonObject1;
        }
    }
}