package com.example.movie.backend;

/**
 * 查询条件
 * @author admin
 *
 */
public class Condition {
	private String screen ="";
	private String classfication ="";
	private int hall =-1;
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getClassfication() {
		return classfication;
	}
	public void setClassfication(String classfication) {
		this.classfication = classfication;
	}
	public int getHall() {
		return hall;
	}
	public void setHall(int hall) {
		this.hall = hall;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private String title="";
	
	public void reset() {
		setClassfication("");
		setHall(-1);
		setTitle("");
		setScreen("");
	}
	
}
