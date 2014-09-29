package com.fmt.rest.sse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.media.sse.EventInput;
import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

public class SseMain {

	public static void main(String[] args) {
		Client client = ClientBuilder.newBuilder()
		        .register(SseFeature.class).build();
		WebTarget target = client.target("http://localhost:9998/events");
		 
		EventInput eventInput = target.request().get(EventInput.class);
		while (!eventInput.isClosed()) {
		    final InboundEvent inboundEvent = eventInput.read();
		    if (inboundEvent == null) {
		        // connection has been closed
		        break;
		    }
		    System.out.println(inboundEvent.getName() + "; "
		        + inboundEvent.readData(String.class));
		}
	}
	
	public static void EventerListenerSource() {
		Client client = ClientBuilder.newBuilder()
                .register(SseFeature.class).build();
		WebTarget target = client.target("http://example.com/events");
		EventSource eventSource = EventSource.target(target).build();
		EventListener listener = new EventListener() {
		@Override
		public void onEvent(InboundEvent inboundEvent) {
		    System.out.println(inboundEvent.getName() + "; "
		            + inboundEvent.readData(String.class));
		}
		};
		eventSource.register(listener, "message-to-client");
		eventSource.open();
		
		eventSource.close();
	}
	
	public static void eventEvent() {
		Client client = ClientBuilder.newBuilder()
                .register(SseFeature.class).build();
		WebTarget target = client.target("http://localhost:8080/new-j2EE/sse/events");
		EventSource eventSource = new EventSource(target) {
		@Override
		public void onEvent(InboundEvent inboundEvent) {
		if ("message-to-client".equals(inboundEvent.getName())) {
		    System.out.println(inboundEvent.getName() + "; "
		            + inboundEvent.readData(String.class));
		}
		}
		};
		
		eventSource.close();
	}

}
