package com.coviam.entity.flightEntity;

import org.springframework.stereotype.Component;

@Component
public class FlightPricingRequest {
    private String flightId;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "FlightPricingRequest{" +
                "flightId='" + flightId + '\'' +
                '}';
    }
}
