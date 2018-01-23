package com.coviam.service;


import com.coviam.entity.flightEntity.FlightSearchResponse;
import com.coviam.util.CommonUtil;
import com.coviam.util.HttpUtility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
@ConfigurationProperties(prefix="endpoint")
public class FlightSearchManager {

    @Value("${endpoint.flightSearch}")
    private String flightSearch;

    public String getAllFlights(HttpServletRequest request) {
        String flightSearchResponse = "";
        HashMap<String,String> flightRequestMap = getFlightSearchParams(request);
        try {
            flightSearchResponse = HttpUtility.service_URLEncoded(flightSearch, HttpUtility.METHOD_GET, flightRequestMap);
        }catch(Exception e){
            System.out.println("Getting Exception in getting Flight Search Results");
        }
        return flightSearchResponse;
    }


    private static HashMap<String,String> getFlightSearchParams(HttpServletRequest request) {
        HashMap<String,String> flightRequestMap = new HashMap<>();
       // System.out.println(" ==============" +request.getParameter("origin") + "===========" );
        //System.out.println(" ==============" +request.getParameter("destination") + "===========" );
        flightRequestMap.put("origin", request.getParameter("origin"));
        flightRequestMap.put("destination", request.getParameter("destination"));
        flightRequestMap.put("originDepartDate", request.getParameter("originDepartDate"));
        flightRequestMap.put("destinationArrivalDate", request.getParameter("destinationArrivalDate"));
        flightRequestMap.put("adults", request.getParameter("adults"));
        flightRequestMap.put("infants", request.getParameter("infants"));
        flightRequestMap.put("children", request.getParameter("children"));
        flightRequestMap.put("flightType", request.getParameter("flightType"));
        return flightRequestMap;
    }





    public  Map<Integer,List<FlightSearchResponse>> transformedFlightSearchRes(String flightSearchResp) {
        Map<Integer, List<FlightSearchResponse>> searchResults = new LinkedHashMap<>();
        List<FlightSearchResponse> oneWayFlightList = new LinkedList<>();
        JSONObject flightSearchResObj =  new JSONObject(flightSearchResp);
        JSONObject responseObj = flightSearchResObj.getJSONObject("response");
        JSONArray searchResultArray = responseObj.getJSONArray("search_results");
        if(searchResultArray.length() > 0){
            JSONArray onGoingFlightArray = searchResultArray.getJSONArray(0);   // oneWay flights
            getAllFlights(onGoingFlightArray,oneWayFlightList);
            searchResults.put(0,oneWayFlightList);
            if(searchResultArray.length() > 1){    // roundTrip flights
                List<FlightSearchResponse> returnTripFlightList = new LinkedList<>();
                JSONArray returnTripFlightArray = searchResultArray.getJSONArray(1);   // ReturnTrip flights
                getAllFlights(returnTripFlightArray,returnTripFlightList);
                searchResults.put(1,returnTripFlightList);
            }
        }
        return searchResults;
    }

    private static void getAllFlights(JSONArray flightJSONArray, List<FlightSearchResponse> flightList) throws JSONException {
        if(flightJSONArray.length() > 0)
        {
            for(int i=0 ; i < flightJSONArray.length() ; i++){
                try {
                    flightList.add(CommonUtil.toEntity(flightJSONArray.getJSONObject(i).toString()));
                }catch(Exception e){
                    System.out.println("Getting Exception in Adding the response");
                }
            }
        }

    }

}
