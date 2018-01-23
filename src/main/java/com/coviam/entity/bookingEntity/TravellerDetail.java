package com.coviam.entity.bookingEntity;


import org.springframework.stereotype.Component;

@Component
public class TravellerDetail {

    private String travellerName;
    private String travellerAge;

    public String getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public String getTravellerAge() {
        return travellerAge;
    }

    public void setTravellerAge(String travellerAge) {
        this.travellerAge = travellerAge;
    }

    @Override
    public String toString() {
        return "TravellerDetail{" +
                "travellerName='" + travellerName + '\'' +
                ", travellerAge='" + travellerAge + '\'' +
                '}';
    }
}
