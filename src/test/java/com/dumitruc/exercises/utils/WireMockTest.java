package com.dumitruc.exercises.utils;

/**
 * Created by dima on 07/08/2015.
 */

import com.dumitruc.exercises.ws.SimpleWSClient;
import com.dumitruc.exercises.ws.globalweather.GetCitiesByCountry;
import com.dumitruc.exercises.ws.globalweather.GetCitiesByCountryResponse;
import com.dumitruc.exercises.ws.globalweather.GetWeather;
import com.dumitruc.exercises.ws.globalweather.GetWeatherResponse;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import javax.xml.soap.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.TestCase.assertTrue;

public class WireMockTest {

    private final static String response="HHHHH";

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8484);

    @Test
    public void exampleTest() throws Throwable{

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPBody body = soapPart.getEnvelope().getBody();
        body.setTextContent(response);

        OutputStream outputStream = new ByteArrayOutputStream();
        soapMessage.writeTo(outputStream);
        String payload = outputStream.toString();
        outputStream.close();

        givenThat(any(urlMatching(".*"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/xml")
                        .withBody(payload)));

        SimpleWSClient simpleWSClient = new SimpleWSClient();
        simpleWSClient.doTest();
        System.out.println("done");
    }

}
