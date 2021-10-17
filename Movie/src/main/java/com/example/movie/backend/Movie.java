package com.example.movie.backend;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.*;
import java.sql.Date;

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
    @JSONField(name = "hall")
    private int hall;
    @JSONField(name = "releaseDate", format = "ddMMyyyy")
    private Calendar releaseDate;
    @JSONField(name = "upcomingTime", format = "HHmmEddMMyyyy")
    private Calendar upcomingTime;
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
        this.hall = 0;
        this.releaseDate = Calendar.getInstance();
        this.upcomingTime = Calendar.getInstance();
        this.seats = new int[10][10];
    }

    public Movie(String title, int length, String synopsis, String director, ArrayList<String> cast,
                  String classification, String screen, double price, int hall, Calendar releaseDate, Calendar upcomingTime, int[][] seats){
        if(movies == null){
            movies = new ArrayList<>();
        }
        this.title = title;
        this.length = length;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.classification = classification;
        this.screen = screen;
        this.price = price;
        this.hall = hall;
        this.releaseDate = releaseDate;
        this.upcomingTime = upcomingTime;
        this.seats = seats;
        if (!isContains(this)){
            movies.add(this);
        }
    }


    public static boolean isContains(Movie mv){
        if(movies == null){
            return false;
        }
        for (Movie m : movies){
            if(m.title.equals(mv.title)
            && m.length == mv.length
            && m.director.equals(mv.director)
            && m.classification.equals(mv.classification)
            && m.screen.equals(mv.screen) && m.upcomingTime.equals(mv.upcomingTime)
            && m.hall == mv.hall){
                return true;
            }
        }
        return false;
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

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Calendar getUpcomingTime() {
        return upcomingTime;
    }

    public void setUpcomingTime(Calendar upcomingTime) {
        this.upcomingTime = upcomingTime;
    }

    public int[][] getSeats() {
        return seats;
    }

    public void setSeats(int[][] seats) {
        this.seats = seats;
    }
}
