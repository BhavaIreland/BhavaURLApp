package com.bhava.zookeeper.service;

import java.util.Random;

public class URLConverterService {
// Notes - TODO
// This service ideally should call backend service that handles the storage system like database.
// for demo purpose, just using in-memory object storage
	    
	    BackendSystem store = BackendSystem.getInstance();
	    
	    static final String randChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	    
	     // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	    
	        Random rand = new Random();
	        int urlLen = 6;
	        char [] shortURL = new char[urlLen];
	        
	        for(int i = 0; i < urlLen; i++ )
	            shortURL[i] = randChars.charAt(rand.nextInt(randChars.length()));
            
	        String sUrl = new String(shortURL);
		// TODO: here we need to validate the uniqueness of the key.
		// couple of options like 
		// 1. adding the userId to the key or 
		// 2. hashing the key 
		// 3. or some other unique factors in the real project
		
	        store.urlMap.put(sUrl,longUrl);
		// keep that above line in try catch block and handle if any collision occures. If collision occures regenerate the key until its unique. Its a rare 
		// situation to have a collision. 
		// or else use the given longUrl as key and validate the unique key as described above
		// if longUrl exists then simple get it and return
		// SINCE ITS A DEMO APP, NOT HANDLED ALL REAL SCENARIOS.
	        return sUrl;

	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {

	    	return (store.urlMap.containsKey(shortUrl)) ? store.urlMap.get(shortUrl) :  null;
	    	
	    }
	
}

