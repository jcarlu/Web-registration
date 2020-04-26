package com.techelevator.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Subscriber;
import com.techelevator.model.SubscriberDao;

/**
 * ApiController
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {

	 @Autowired
	 private SubscriberDao subscriberDao;
	 
	   @PostMapping("/register")
	    public void addSubscriber(@RequestBody  @Valid Subscriber subscriber ) {
		   subscriberDao.saveSubscriber(subscriber);
	    }

  
}