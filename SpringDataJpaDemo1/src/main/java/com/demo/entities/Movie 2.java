package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	private String title;
	private int numberInStock;
	private int dailyRentalRate;
	
	@ManyToOne
	private Genre genre;
	
	public Movie() {
		super();
	}
	
	

	public Movie(String title, int numberInStock, int dailyRentalRate, Genre genre) {
		super();
		this.title = title;
		this.numberInStock = numberInStock;
		this.dailyRentalRate = dailyRentalRate;
		this.genre = genre;
	}



	public Genre getGenre() {
		return genre;
	}



	public void setGenre(Genre genre) {
		this.genre = genre;
	}



	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberInStock() {
		return numberInStock;
	}

	public void setNumberInStock(int numberInStock) {
		this.numberInStock = numberInStock;
	}

	public int getDailyRentalRate() {
		return dailyRentalRate;
	}

	public void setDailyRentalRate(int dailyRentalRate) {
		this.dailyRentalRate = dailyRentalRate;
	}



	@Override
	public String toString() {
		return "\n\tMovie [_id=" + _id + ", title=" + title + ", numberInStock=" + numberInStock + ", dailyRentalRate="
				+ dailyRentalRate + ", genre=" + genre + "]";
	}
	
	
	
}
