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
}
