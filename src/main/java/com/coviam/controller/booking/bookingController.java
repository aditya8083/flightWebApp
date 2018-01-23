package com.coviam.controller.booking;

import com.coviam.entity.bookingEntity.Booking;
import com.coviam.service.BookingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class bookingController {
    @Autowired BookingManager bookingManager;

    @RequestMapping(value = "/booking/createBooking", method = RequestMethod.POST)
    public String createBooking(@RequestBody Booking booking) {
        System.out.println("creating partial Booking ");
        String partialBookingResponse = bookingManager.createBooking(booking);
        System.out.println(partialBookingResponse);
        return "";

    }


}
