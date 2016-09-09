package com.example.controller;

import com.example.api.User;
import com.example.db.TripData;
import com.example.db.UserData;
import com.example.db.TripDataRepository;

import com.example.db.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ayesh on 9/9/16.
 */
@Controller
@Component
@RequestMapping(path = "/rtw/user_details")
public class UserApiController {
    private final UserDataRepository udrep;

    @Autowired
    public UserApiController(UserDataRepository udr){
        this.udrep = udr;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST,path = "/")
    @ResponseBody
    public User saveUser(@RequestBody User user){
        UserData ud = new UserData();
        ud.setu_name(user.getu_name());
        ud.setName(user.getName());
        ud.setEmail(user.getEmail());
        ud.setPassword(user.getPassword());
        udrep.save(ud);
        return user;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PUT,path="/")
    @ResponseBody
    public User updateUser(@RequestBody User user){
        UserData ud = new UserData();
        ud.setu_id(user.getu_id());
        ud.setu_name(user.getu_name());
        ud.setName(user.getName());
        ud.setEmail(user.getEmail());
        ud.setPassword(user.getPassword());
        udrep.save(ud);
        return user;
    }





}
