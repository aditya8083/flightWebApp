package com.coviam.controller.flight;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlightView {

    @RequestMapping(value = "/flightSearch", method = RequestMethod.GET)
    public ModelAndView flightSearchView()
    {
        ModelAndView mav = new ModelAndView("flightSearchRequests");
        return mav;
    }
}
