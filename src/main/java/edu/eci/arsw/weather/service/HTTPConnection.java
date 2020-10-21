package edu.eci.arsw.weather.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Class that implements the connection with the api
 * @author Maria Fernanda Hernandez Vargas
 */
@Service ("conectionAPI")
public class HTTPConnection {

    /**
     * Method that obtains the information by name from API service
     * @param name
     * @return
     * @throws WeatherException
     */
    public JSONObject getAllByName (String name) throws WeatherException {
        try {
            HttpResponse<String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=a559bbf577419855ea093787975d928d")
                    .header("q", name)
                    .header("appid", "a559bbf577419855ea093787975d928d")
                    .asString();
            return new JSONObject(response.getBody());
        }catch (Exception e){
            throw new WeatherException(WeatherException.CONNECTION_FAILED);
        }
    }
}