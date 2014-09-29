package com.fmt.rest.sse;

public class StockQuote {
	float price;
	String name;
	
	public StockQuote(String name, float price) {
		this.price= price;
		this.name= name;
	}
}
