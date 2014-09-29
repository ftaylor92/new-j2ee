package com.fmt.rest.sse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.media.sse.EventOutput;

//@Path(“tickers”)
public class StockTickerResource {
	// @GET @Produces(“text/event-stream”)
	public EventOutput getQts() {
		EventOutput eo = new EventOutput();
		// new StockThread(eo).start();
		return eo;
	}
}
