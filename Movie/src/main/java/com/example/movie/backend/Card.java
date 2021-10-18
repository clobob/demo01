package com.example.movie.backend;


public class Card {
	private String cardNumber;
	private String ownerName;
	
	public Card(String setCardNumber, String ownerName) {
		this.setCardNumber(setCardNumber);
		this.ownerName = ownerName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
