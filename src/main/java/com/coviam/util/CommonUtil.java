package com.coviam.util;

import com.coviam.entity.flightEntity.FlightSearchResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class CommonUtil {

    public static FlightSearchResponse toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            FlightSearchResponse flightSearchInfo = gson.fromJson(jsonString, FlightSearchResponse.class);
            return flightSearchInfo;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

}
