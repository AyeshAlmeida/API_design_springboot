package com.example.controller;

import com.example.api.Trip;
import com.example.db.TripData;
import com.example.db.TripDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ayesh on 9/8/16.
 */
@Controller
@Component
@RequestMapping(path="/rtw")
public class TripApiController {

    private final TripDataRepository tdrep;

    @Autowired
    public TripApiController(TripDataRepository tdr){
        this.tdrep = tdr;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST,path="/")
    @ResponseBody
    public Trip saveTrip(@RequestBody Trip trip){
        TripData td = new TripData();
        td.sett_Date(trip.gett_Date());
        td.sett_class(trip.gett_class());
        td.sets_loc(trip.gets_loc());
        td.sete_loc(trip.gete_loc());
        td.setPassengers(trip.getPassengers());
        tdrep.save(td);
        return trip;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PUT,path="/")
    @ResponseBody
    public Trip updateTrip(@RequestBody Trip trip){
        TripData td = new TripData();
        td.sett_id(trip.gett_id());
        td.sett_Date(trip.gett_Date());
        td.sett_class(trip.gett_class());
        td.sets_loc(trip.gets_loc());
        td.sete_loc(trip.gete_loc());
        td.setPassengers(trip.getPassengers());
        tdrep.save(td);
        return trip;
    }
}
