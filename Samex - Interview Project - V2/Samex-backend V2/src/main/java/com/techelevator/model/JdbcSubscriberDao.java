package com.techelevator.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	    public void saveSubscriber(Subscriber subscriber) throws NoSuchAlgorithmException {
		    
		    subscriber.setHexId(toHexString(getMD5(subscriber.getEmail()))); 
		    
	        String addSubscriber = "INSERT INTO subscriber (hex_id, first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?, ?)";
	        jdbcTemplate.update(addSubscriber,
	        		subscriber.getHexId(),
	        		subscriber.getFirstName(),
	        		subscriber.getLastName(),
	        		subscriber.getEmail(),
	        		subscriber.getPhoneNumber());
	    }
	 
	 public static byte[] getMD5(String input) throws NoSuchAlgorithmException {   
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
	    } 
	    
	 public static String toHexString(byte[] hash) {
	        BigInteger number = new BigInteger(1, hash); 
	        StringBuilder hexString = new StringBuilder(number.toString(16));  
	  
	        while (hexString.length() < 32)  
	        {  
	            hexString.insert(0, '0');  
	        }  
	        return hexString.toString();  
	    } 

}
