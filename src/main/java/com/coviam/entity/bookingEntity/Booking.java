package com.coviam.entity.bookingEntity;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Booking {
    private String userId;
    private String bookingType;
    private String bookingSource;
    private String bookingContactNo;
    private String bookingEmailId;
    private String superPnr;
    private List<TravellerDetail> travellerDetail;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(String bookingSource) {
        this.bookingSource = bookingSource;
    }

    public String getBookingContactNo() {
        return bookingContactNo;
    }

    public void setBookingContactNo(String bookingContactNo) {
        this.bookingContactNo = bookingContactNo;
    }

    public String getBookingEmailId() {
        return bookingEmailId;
    }

    public void setBookingEmailId(String bookingEmailId) {
        this.bookingEmailId = bookingEmailId;
    }

    public String getSuperPnr() {
        return superPnr;
    }

    public void setSuperPnr(String superPnr) {
        this.superPnr = superPnr;
    }

    public List<TravellerDetail> getTravellerDetail() {
        return travellerDetail;
    }

    public void setTravellerDetail(List<TravellerDetail> travellerDetail) {
        this.travellerDetail = travellerDetail;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "userId='" + userId + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", bookingSource='" + bookingSource + '\'' +
                ", bookingContactNo='" + bookingContactNo + '\'' +
                ", bookingEmailId='" + bookingEmailId + '\'' +
                ", superPnr='" + superPnr + '\'' +
                ", travellerDetail=" + travellerDetail +
                '}';
    }
}
