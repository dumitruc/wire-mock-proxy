package com.dumitruc.exercises.ws;

import com.dumitruc.exercises.ws.globalweather.GlobalWeather;
import com.dumitruc.exercises.ws.globalweather.GlobalWeatherSoap;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Response;
import javax.xml.ws.WebServiceRef;
import java.net.URL;
import java.sql.Timestamp;

/**
 * Created by dima on 08/08/2015.
 */

public class SimpleWSClient {

    //    @WebServiceRef(wsdlLocation = "http://www.webservicex.com/globalweather.asmx?WSDL")
//    public static GlobalWeather service;


//    static URL newWsdUrl = new URL("http://localhost:8383/globalweather.asmx?WSDL");
    static GlobalWeather service = new GlobalWeather();

    public static void main(String[] args) {
        try {
            SimpleWSClient client = new SimpleWSClient();
            client.doTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doTest() {
        try {



            System.out.println("Retrieving the port from the following service: " + service);
            GlobalWeatherSoap globalWeatherSoap = service.getGlobalWeatherSoap();

            String endpointURL ="http://localhost:8383/globalweather.asmx";
            BindingProvider bp = (BindingProvider)globalWeatherSoap;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);




            long startTime = System.nanoTime();
            String response = globalWeatherSoap.getCitiesByCountry("United Kingdom");
            long endTime = System.nanoTime();
            System.out.printf("It took %s milliseconds to execute",(endTime-startTime)/1000000);
            System.out.println("Response = " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
