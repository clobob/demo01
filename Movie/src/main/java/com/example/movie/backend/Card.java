package com.example.movie.backend;


public class Card {
	private String cardNumber;
	private String ownerName;
	
	public Card(String cardNString, String owString) {
		this.setCardNumber(cardNString);
		this.ownerName = owString;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
