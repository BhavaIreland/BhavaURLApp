package com.bhava.api;

import java.net.URI;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.bhava.zookeeper.service.URLConverterService;

@Path("/rest")

public class URLDemoAppService {

	
	URLConverterService converter = new URLConverterService();
	 
	@GET
	@Path("/{shortUrl}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveConfigStore( @Context UriInfo ui, @PathParam("shortUrl") String shortUrl) {
//		
	     try {

	    	// check the input shortUrl validation if any 
	    	
	    	 String longUrl = converter.decode(shortUrl);
	    	 
	    	 if (longUrl != null) {
	    	   URI uri = new URI(longUrl);	 
	    	   return Response.status(Response.Status.FOUND).location(uri).build();
	    	 } else {
	    		 return Response.status(Response.Status.NOT_FOUND).build(); 
	    	 }
			
		} catch (Throwable t) {
			 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(); 
		} // catch end 
	     
	} // method end 	
	
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveConfigStore( @Context UriInfo ui, Map<String, Object> jsonData) {
//		
	     try {
	    	// check the input jsonData validation if any 
	    	 String longUrl;
	    	 
	    	 if (jsonData != null && jsonData.get("longUrl")!= null && !jsonData.get("longUrl").toString().isEmpty())
	    	     longUrl = jsonData.get("longUrl").toString();
	    	 else
	    		 return Response.status(Response.Status.FORBIDDEN).entity("Input/Request data is not valid").build(); 
	    	
	    	 String shortUrl = converter.encode(longUrl);
	    	 
	    	 return Response.status(Response.Status.CREATED).entity("http://localhost:9080/BhavaURLApp/v1/rest/" + shortUrl).header("Location", shortUrl).build(); 
			
		} catch (Throwable t) {
			 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(); 
		} // catch end 
	     
	} // method end 
	
	
} // class end 
