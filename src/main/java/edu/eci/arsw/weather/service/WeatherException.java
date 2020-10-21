package edu.eci.arsw.weather.service;

/**
 * Class that implements aplication exception
 * @author Maria Fernanda Hernandez Vargas
 */
public class WeatherException extends Exception{
    public static String CONNECTION_FAILED = "Coneccion fallida.";

    /**
     * Method that obtains the message of the exception
     * @param message
     */
    public WeatherException(String message){
        super(message);
    }
}
