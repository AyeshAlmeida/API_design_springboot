package com.example.controller;

import com.example.api.Trip;
import com.example.db.TripData;
import com.example.db.TripDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    @ResponseBody
    public Trip getTripById(@PathVariable("id") String id){
        TripData td = tdrep.findOne(Long.valueOf(id));
        Trip trip = convertToTrip(td);
        return trip;
    }

    private Trip convertToTrip(TripData td){
        Trip trip = new Trip();
        trip.sett_id(td.gett_id());
        trip.sett_Date(td.gett_Date());
        trip.sett_class(td.gett_class());
        trip.sets_loc(td.gets_loc());
        trip.sete_loc(td.gete_loc());
        trip.setPassengers(td.getPassengers());
        return trip;
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET,path="/start/{s_loc}")
    @ResponseBody
    public List<Trip> getTripByStart(@PathVariable("s_loc") String s_loc){
        List<TripData> byStart = tdrep.findByStart(s_loc);
        return byStart.stream().map(this::convertToTrip).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET,path = "/end/{e_loc}")
    @ResponseBody
    public List<Trip> getTripByEnd(@PathVariable("e_loc") String e_loc){
        List<TripData> byEnd = tdrep.findByEnd(e_loc);
        return byEnd.stream().map(this::convertToTrip).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET,path = "/t_class/{t_class}")
    @ResponseBody
    public List<Trip> getTripByClass(@PathVariable("t_class") int t_class){
        List<TripData> byClass = tdrep.findByClass(t_class);
        return byClass.stream().map(this::convertToTrip).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET,path="/t_date/{t_date}")
    @ResponseBody
    public List<Trip> getTripByDate(@PathVariable("t_date") String t_date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(t_date);
            List<TripData> byDate = tdrep.findByDate(date);
            return byDate.stream().map(this::convertToTrip).collect(Collectors.toList());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Trip> getTripByQuery(@RequestParam("t_date") String t_date, @RequestParam("t_class") int t_class, @RequestParam("s_location") String start, @RequestParam("e_location") String ends){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try{
            date = sdf.parse(t_date);
            List<TripData> byQuery = tdrep.findByQuery(date,t_class,start,ends);
            return byQuery.stream().map(this::convertToTrip).collect(Collectors.toList());
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
}
