package com.demo;

public class CurrencyConversion {
	
	private int id;
	private String from;
	private String to;
	private double exchangeRate;
	private int qty;
	private double totalCalculatedAmount;
	
	public CurrencyConversion() {
		super();
	}
	
	

	public CurrencyConversion(int id, String from, String to, double exchangeRate, int qty,
			double totalCalculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
		this.qty = qty;
		this.totalCalculatedAmount = totalCalculatedAmount;
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

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(double totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	
	
	

}
