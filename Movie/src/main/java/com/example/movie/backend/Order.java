package com.example.movie.backend;

import java.util.List;

public class Order {
	
	public Order(String id, Logged logged, Movie movie, List<List<Integer>> seatIndex) {
		setId(id);
		setCustomer(logged);
		setMovie(movie);
		setSeatsIndex(seatIndex);
	}
	
	private List<List<Integer>> seatsIndex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Logged getCustomer() {
		return customer;
	}
	public void setCustomer(Logged customer) {
		this.customer = customer;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<List<Integer>> getSeatsIndex() {
		return seatsIndex;
	}
	public void setSeatsIndex(List<List<Integer>> seatsIndex) {
		this.seatsIndex = seatsIndex;
	}

	private String id;
	private Logged customer;
	private Movie movie;
}
