package com.techelevator.model;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcSubscriberDao implements SubscriberDao {
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSubscriberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}; 
	
	 @Override
	    public void saveSubscriber(Subscriber subscriber) {
	       
	        String addSubscriber = "INSERT INTO subscriber (first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)";
	        jdbcTemplate.update(addSubscriber,
	        		subscriber.getFirstName(),
	        		subscriber.getLastName(),
	        		subscriber.getEmail(),
	        		subscriber.getPhoneNumber());
	    }

}
