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
	        store.urlMap.put(sUrl,longUrl);
	        return sUrl;

	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {

	    	return (store.urlMap.containsKey(shortUrl)) ? store.urlMap.get(shortUrl) :  null;
	    	
	    }
	
}

