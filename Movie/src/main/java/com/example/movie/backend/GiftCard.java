package com.example.movie.backend;

import java.util.UUID;

public class GiftCard {
	private boolean status;
	private String number;
	
	public GiftCard() {
		status = false;
		number = UUID.randomUUID().toString();
	}
}
