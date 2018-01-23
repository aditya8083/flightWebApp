package com.coviam.service;

import com.coviam.entity.bookingEntity.Booking;
import com.coviam.util.HttpUtility;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@ConfigurationProperties(prefix = "endpoint")
public class BookingManager {

    @Value("${endpoint.booking}")
    private String flightBooking;


    public String createBooking(Booking booking) {
        String bookingResponse = "";
        try {
            System.out.println("Booking Params : ==========" + booking);
            bookingResponse = HttpUtility.service_AppJSON(flightBooking, HttpUtility.METHOD_POST, getJSONObject(booking));
        } catch (Exception e) {
            System.out.println("Exception in making the partial Booking");
        }
        return bookingResponse;

    }

    private JSONObject getJSONObject(Booking booking) {
        Gson gsonObj = new Gson();
        return new JSONObject(gsonObj.toJson(booking));

    }
}
