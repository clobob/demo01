package com.example.movie.backend;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.*;

public class Movie {
    @JSONField(serialize = false, deserialize = false)
    private static ArrayList<Movie> movies;
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "length")
    private int length;
    @JSONField(name = "synopsis")
    private String synopsis;
    @JSONField(name = "director")
    private String director;
    @JSONField(name = "cast")
    private ArrayList<String> cast;
    @JSONField(name = "classification")
    private String classification;
    @JSONField(name = "screen")
    private String screen;
    @JSONField(name = "price")
    private double price;
    @JSONField(name = "releaseDate", format = "ddMMyyyy")
    private Calendar releaseDate;
    @JSONField(name = "upcomingTime", format = "HHmmEddMMyyyy")
    private Date upcomingTime;
    @JSONField(name = "seats")
    private int[][] seats;


    public Movie(){
        if(movies == null){
            movies = new ArrayList<>();
        }
        this.title = "not set up";
        this.length = 0;
        this.synopsis = "not set up";
        this.director = "not set up";
        this.cast = new ArrayList<>();
        this.classification = "not set up";
        this.screen = "not set up";
        this.price = 0.0;
        this.releaseDate = Calendar.getInstance();
        this.upcomingTime = new Date();
        this.seats = new int[10][10];
    }

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    public static void setMovies(ArrayList<Movie> movies) {
        Movie.movies = movies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getUpcomingTime() {
        return upcomingTime;
    }

    public void setUpcomingTime(Date upcomingTime) {
        this.upcomingTime = upcomingTime;
    }

    public int[][] getSeats() {
        return seats;
    }

    public void setSeats(int[][] seats) {
        this.seats = seats;
    }
}
