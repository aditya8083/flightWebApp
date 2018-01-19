package com.coviam.controller;
import com.coviam.entity.FlightSearchResponse;
import com.coviam.service.FlightSearchManager;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FlightSearchController {
    @Autowired
    FlightSearchManager flightSearchManager;

    @RequestMapping(value = "/flightSearch", method = RequestMethod.GET)
    public ModelAndView flightSearchView()
    {
        ModelAndView mav = new ModelAndView("flightSearchRequests");
        return mav;
    }

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
        return "flightSearchResult";
    }


}
