package com.fmt.rest.service;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

@Path("/fast")
public class FastService {
	public final static int FILEPATHMAX= 255;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response httpResponse(
			@QueryParam("id") String id,
			@QueryParam("seconds") int seconds,
			@Context HttpServletRequest servletRequest) {
		Status stat= Response.Status.NO_CONTENT;
		
		CacheControl cc = new CacheControl();
		cc.setMaxAge(60);
		cc.setNoCache(true);
		
		try {
			Thread.sleep(1000* seconds);
			stat= Response.Status.OK;
		} catch (InterruptedException e) {
			e.printStackTrace();
			stat= Response.Status.INTERNAL_SERVER_ERROR;
		}

		//return lines;
		ResponseBuilder rb = Response.status(stat).entity(String.format("id: %s at: %s", id, LocalTime.now().toString()));
		System.out.println("Response: "+ id);
		return rb.cacheControl(cc).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods","GET").build();

	}
}
