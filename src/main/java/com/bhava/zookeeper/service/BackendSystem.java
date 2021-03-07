package com.bhava.zookeeper.service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class BackendSystem {
	static volatile ConcurrentHashMap<String, String> urlMap;
    private static BackendSystem single_instance = null;
    
	private BackendSystem() {
		   urlMap = new ConcurrentHashMap<>();
	}

	public static BackendSystem getInstance() {
		
		if (single_instance == null)
			single_instance =  new BackendSystem();
		
		return single_instance;
	}

}
