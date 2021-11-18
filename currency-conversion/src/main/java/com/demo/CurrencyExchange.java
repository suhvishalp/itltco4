package com.demo;

public class CurrencyExchange {
	
	private int id;
	private String from;
	private String to;
	private double exchangeRate;
	private String environment;
	
	public CurrencyExchange() {
		super();
	}

	public CurrencyExchange(int id, String from, String to, double exchangeValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getExchangeValue() {
		return exchangeRate;
	}

	public void setExchangeValue(double exchangeValue) {
		this.exchangeRate = exchangeValue;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
