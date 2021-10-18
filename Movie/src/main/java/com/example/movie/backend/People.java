package com.example.movie.backend;

import java.util.UUID;

public class People {
	private int peopleClass;
	private String id;
	
	/**
	 * UUID
	 * 自动生成 id;
	 */
	public People() {
		id = UUID.randomUUID().toString();
	}
	public int getPeopleClass() {
		return peopleClass;
	}
	public void setPeopleClass(int peopleClass) {
		this.peopleClass = peopleClass;
	}

}	
