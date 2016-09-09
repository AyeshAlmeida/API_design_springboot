package com.example.controller;

import com.example.api.User;
import com.example.db.UserData;
import com.example.db.TripDataRepository;

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

}
