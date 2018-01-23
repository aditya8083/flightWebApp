package com.coviam.service;

import com.coviam.entity.flightEntity.FlightPricingResponse;
import com.coviam.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
@ConfigurationProperties(prefix = "endpoint")
public class FlightPricingManager {

    @Value("${endpoint.flightPrice}")
    private String flightPrice;

    @Value("${endpoint.flightItinerary}")
    private String flightItinerary;


    @Autowired EscapeCharacter escapeCharacter;

    public String getFlightPricing(HttpServletRequest request) {
        String flightPricingResponse = "";
        HashMap<String, String> flightPricingMap = getFlightPricingParams(request);

        try {
            flightPricingResponse = HttpUtility.service_URLEncoded(flightPrice, HttpUtility.METHOD_GET, flightPricingMap);
        } catch (Exception e) {
            System.out.println("Getting Exception in getting Flight Search Results");
        }
        return flightPricingResponse;
    }

    private HashMap<String, String> getFlightPricingParams(HttpServletRequest request) {
        HashMap<String, String> flightPricingMap = new HashMap<>();
        flightPricingMap.put("flightId", request.getParameter("flightId"));
        flightPricingMap.put("origin", request.getParameter("origin"));
        flightPricingMap.put("destination", request.getParameter("destination"));
        flightPricingMap.put("departDate", request.getParameter("departDate"));
        flightPricingMap.put("returnDate", request.getParameter("returnDate"));
        flightPricingMap.put("flightType", request.getParameter("flightType"));
        flightPricingMap.put("adult", request.getParameter("adult"));
        flightPricingMap.put("infant", request.getParameter("infant"));
        flightPricingMap.put("child", request.getParameter("child"));
        return flightPricingMap;
    }


    public String transformedFlightPricingRes(String flightPriceResp) {
        JSONObject flightResObj = new JSONObject();
        JSONArray  flightPriceResponseArr = new JSONArray();
        JSONObject flightPriceResObj = new JSONObject(flightPriceResp);
        JSONObject responseObj = flightPriceResObj.getJSONObject("response");

        JSONArray priceResultArray = responseObj.getJSONArray("details_result");
        if (priceResultArray.length() > 0) {
            JSONArray flightPriceArray = priceResultArray.getJSONArray(0);   // oneWay flights
            getAllFlights(flightPriceArray, flightPriceResponseArr);
            if(priceResultArray.length() > 1){    // roundTrip flights
                JSONArray returnTripFlightArray = priceResultArray.getJSONArray(1);   // ReturnTrip flights
                getAllFlights(returnTripFlightArray, flightPriceResponseArr);
            }
        }
        flightResObj.put("flightPriceResponse", flightPriceResponseArr.toString());
        flightResObj.put("superPnr", flightPriceResObj.getString("superPnr"));
        flightResObj.put("totalPrice", flightPriceResObj.getString("totalPrice"));
        return escapeCharacter.escapeCharacter(flightResObj.toString());
    }

    private String getTotalPrice(JSONArray flightPriceResponseArr) {
    return "";
    }

    private static void getAllFlights(JSONArray flightJSONArray, JSONArray flightPriceResponseArr) throws JSONException {
        if (flightJSONArray.length() > 0) {
            for (int i = 0; i < flightJSONArray.length(); i++) {
                try {
                    flightPriceResponseArr.put(flightJSONArray.getJSONObject(i));
                } catch (Exception e) {
                    System.out.println("Getting Exception in Adding the response");
                }
            }
        }

    }
    public static FlightPricingResponse toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            FlightPricingResponse flightPriceInfo = gson.fromJson(jsonString, FlightPricingResponse.class);
            return flightPriceInfo;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public String getFlightItineraryDetails(HttpServletRequest request, String superPnr) {
        String flightItineraryResponse = "";
        HashMap<String, String> flightItineraryMap = getFlightItineraryMap(request,superPnr);

        try {
            flightItineraryResponse = HttpUtility.service_URLEncoded(flightItinerary, HttpUtility.METHOD_GET, flightItineraryMap);
        } catch (Exception e) {
            System.out.println("Getting Exception in getting Flight Search Results");
        }
        return flightItineraryResponse;


    }

    private HashMap<String,String> getFlightItineraryMap(HttpServletRequest request, String superPnr) {
        HashMap<String, String> flightItineraryMap = new HashMap<>();
        flightItineraryMap.put("superPnr", superPnr);
        return flightItineraryMap;

    }
}


