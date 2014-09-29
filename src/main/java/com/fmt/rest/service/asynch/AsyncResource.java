package com.fmt.rest.service.asynch;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

@Path("/resource")
public class AsyncResource {
    @GET
    public Response asyncGet(@Suspended final AsyncResponse asyncResponse) {
    	String id= Thread.currentThread().getName();
    	
    	Status stat= Response.Status.NO_CONTENT;
		CacheControl cc = new CacheControl();
		cc.setMaxAge(60);
		cc.setNoCache(true);
		
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = veryExpensiveOperation();
                asyncResponse.resume(result);
            }
 
            private String veryExpensiveOperation() {
            	final int seconds= 5;
            	//try {
            		String started= LocalDateTime.now().toString();
        			//Thread.sleep(1000* seconds);
        			//stat= Response.Status.OK;
        			started+= " - to - "+ LocalDateTime.now().toString();
        			return started;
        		//} catch (InterruptedException e) {
        			//e.printStackTrace();
        			//stat= Response.Status.INTERNAL_SERVER_ERROR;
        			//return "Interrupted Exception";
        		//}
            }
        }).start();
        
        stat= Response.Status.OK;
		ResponseBuilder rb = Response.status(stat).entity(String.format("id: %s at: %s", id, LocalTime.now().toString()));
		System.out.println("Response: "+ id);
		return rb.cacheControl(cc).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods","GET").build();

    }
}