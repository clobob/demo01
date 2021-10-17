package com.example.movie.backend;
import com.alibaba.fastjson.annotation.JSONField;
import javafx.util.Pair;

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
    @JSONField(name = "hall")
    private int hall;
    @JSONField(name = "releaseDate", format = "ddMMyyyy")
    private Calendar releaseDate;
    @JSONField(name = "upcomingTime", format = "HHmmEddMMyyyy")
    private Calendar upcomingTime;
    @JSONField(name = "seats")
    private int[][] seats;

    //!!!don't use this initialize, it is use for set up cards from Json
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

    //Initialize a movie
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


    //Determine if a movie exists
    public static boolean isContains(Movie mv){
        if(movies == null){
            return false;
        }
        for (Movie m : movies){
            if(m.title.equals(mv.title)
            && m.length == mv.length
            && m.director.equals(mv.director)
            && m.classification.equals(mv.classification)
            && m.screen.equals(mv.screen)
            && m.hall == mv.hall
            && m.upcomingTime.get(Calendar.YEAR) == mv.upcomingTime.get(Calendar.YEAR)
            && m.upcomingTime.get(Calendar.MONTH) == mv.upcomingTime.get(Calendar.MONTH)
            && m.upcomingTime.get(Calendar.DATE) == mv.upcomingTime.get(Calendar.DATE)
            && m.upcomingTime.get(Calendar.HOUR_OF_DAY) == mv.upcomingTime.get(Calendar.HOUR_OF_DAY)
            && m.upcomingTime.get(Calendar.MINUTE) == mv.upcomingTime.get(Calendar.MINUTE)
            && m.upcomingTime.get(Calendar.SECOND) == mv.upcomingTime.get(Calendar.SECOND)) {
                return true;
            }
        }
        return false;
    }

    //filter movies by screen
    public static ArrayList<Movie> filterMoviesByScreen(String screen){
        ArrayList<Movie> moviesByScreen = new ArrayList<>();
        for(Movie mv : movies){
            if (mv.screen.equals(screen)){
                moviesByScreen.add(mv);
            }
        }
        return moviesByScreen;
    }

    //filter movies by classification
    public static ArrayList<Movie> filterMoviesByClassification(String classification){
        ArrayList<Movie> moviesByClassification = new ArrayList<>();
        for(Movie mv : movies){
            if (mv.classification.equals(classification)){
                moviesByClassification.add(mv);
            }
        }
        return moviesByClassification;
    }

    //filter movies by hall
    public static ArrayList<Movie> filterMoviesByHall(int hall){
        ArrayList<Movie> moviesByHall = new ArrayList<>();
        for(Movie mv : movies){
            if (mv.hall == hall){
                moviesByHall.add(mv);
            }
        }
        return moviesByHall;
    }

    //search movies by title
    public static ArrayList<Movie> searchMoviesByTitle(String title){
        ArrayList<Movie> moviesByHTitle = new ArrayList<>();
        for(Movie mv : movies){
            if (mv.title.equals(title)){
                moviesByHTitle.add(mv);
            }
        }
        return moviesByHTitle;
    }

    //helping method for select seat
    public ArrayList<Pair<Integer, Integer>> getEmptySeat(int range1, int range2){
        ArrayList<Pair<Integer, Integer>> emptySeats = new ArrayList<>();
        for (int i = range1; i <= range2; i++){
            for (int j = 0; j <= 9; j++){
                if (this.seats[i][j] == 0){
                    emptySeats.add(new Pair<>(i, j));
                }
            }
        }
        return emptySeats;
    }

    //selecting a seat by front, middle, and rear.
    //return a pair where the key is the row and the value is column
    //return row as -1 and column as -1 represent there are no seat
    public Pair<Integer, Integer> selectSeat(String location){
        ArrayList<Pair<Integer, Integer>> emptySeats;
        switch(location){
            case "front":
                emptySeats = getEmptySeat(0, 2);
                break;
            case "middle":
                emptySeats = getEmptySeat(3, 6);
                break;
            case "rear":
                emptySeats = getEmptySeat(7, 9);
                break;
            default:
                return new Pair<>(-1, -1);
        }if (emptySeats.size() == 0){
            return new Pair<>(-1, -1);
        }
        Pair<Integer, Integer> seat = emptySeats.get(new Random().nextInt(emptySeats.size()));
        return new Pair<>(seat.getKey() + 1, seat.getValue() + 1);
    }

    //cancel a seat order by input row and column
    public boolean cancelSeat(int row, int column){
        if(this.seats[row -1][column -1] == 1){
            this.seats[row -1][column -1] = 0;
            return true;
        }return false;
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
