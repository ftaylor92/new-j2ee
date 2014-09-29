package com.fmt.rest.sse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.glassfish.grizzly.http.server.Session;

class StockThread extends Thread {
	private Session ss;
	private AtomicBoolean ab = new AtomicBoolean(true);

	public StockThread(Session ss) {
		this.ss = ss;
	}

	public void terminate() {
		ab.set(false);
	}

	@Override
	public void run() {
		while (ab.get()) {
			//try {
				//ss.send(new StockQuote("Coke", 16.73F));
				// ...
			//} catch (IOException e) {
				return;
			//}
		}
	}
}
