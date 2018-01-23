package com.coviam.controller.flight;


import com.coviam.entity.flightEntity.FlightSearchResponse;
import com.coviam.service.FlightPricingManager;
import com.coviam.service.FlightSearchManager;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FlightController {

    @Autowired FlightSearchManager flightSearchManager;
    @Autowired FlightPricingManager flightPricingManager;

    @RequestMapping(value = "/flight/search", method = RequestMethod.GET)
    public String flightSearch(HttpServletRequest request, Model model) throws JSONException {
        System.out.println("Getting all Flights");
        Map<Integer, List<FlightSearchResponse>> flightMap = new LinkedHashMap<>();
        String searchResponse = flightSearchManager.getAllFlights(request);
        if(!StringUtils.isEmpty(searchResponse)) {
            flightMap = flightSearchManager.transformedFlightSearchRes(searchResponse);
        }
        System.out.println(flightMap.toString());
        model.addAttribute("flightSearchRes", flightMap);
        model.addAttribute("origin", request.getParameter("origin"));
        model.addAttribute("destination", request.getParameter("destination"));
        model.addAttribute("departDate", request.getParameter("originDepartDate"));
        model.addAttribute("returnDate", request.getParameter("destinationArrivalDate"));
        model.addAttribute("flightType", request.getParameter("flightType"));
        model.addAttribute("adult", request.getParameter("adults"));
        model.addAttribute("infant", request.getParameter("infants"));
        model.addAttribute("child", request.getParameter("children"));
        return "flightSearchResult";
    }

    @RequestMapping(value = "/flight/price", method = RequestMethod.GET)
    public String flightPricing(HttpServletRequest request, Model model) {
        System.out.println("Getting Flight Pricing");
        String flightPricingResponse = "";
        String pricingResponse = flightPricingManager.getFlightPricing(request);
       /* if(!StringUtils.isEmpty(pricingResponse)) {
            flightPricingResponse = flightPricingManager.transformedFlightPricingRes(pricingResponse);
        }*/
        // System.out.println("reached here ========================================");
        System.out.println(flightPricingResponse);
        model.addAttribute("flightPriceResponse", pricingResponse);
        return "flightPriceResult";

    }

     @RequestMapping(value = "/flight/getFlightItineraryDetails", method = RequestMethod.GET)
     public String getFlightItineraryDetails(HttpServletRequest request, @RequestParam(value = "superPnr", required = true) String superPnr) {
         System.out.println("Getting Flight Itinerary Details");
         String flightItineraryDetails = flightPricingManager.getFlightItineraryDetails(request,superPnr);
         System.out.println(flightItineraryDetails);
         return "flightPriceResult";

     }
}
