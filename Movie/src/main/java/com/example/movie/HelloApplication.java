package com.example.movie;

import com.example.movie.backend.JsonAdapter;
import com.example.movie.backend.Movie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Movie.setMovies(JsonAdapter.getMoviesFromJson("Movies.json"));

        String m1_synopsis = "Sardar Udham is a 2021 Indian Hindi-language"
        +"biographical historical drama film based on the life of Udham Singh,"
        +"a revolutionary freedom fighter highly known for assassinating Michael O'"
        +"Dwyer in London to avenge the 1919 Jallianwala Bagh massacre in Amritsar.[1]"
        +"Starring Vicky Kaushal as Singh, the film is directed by Shoojit Sircar and"
        +"produced by Rising Sun Films in collaboration with Kino Works.[2] The film"
        +"premiered on 16 October 2021 on Amazon Prime Video.";

        Calendar m1_releaseDate = Calendar.getInstance();
        m1_releaseDate.set(2021, Calendar.OCTOBER, 16, 0, 0, 0);

        Calendar m1_upcomingDate =  Calendar.getInstance();
        m1_upcomingDate.set(2021, Calendar.OCTOBER, 16, 15, 30, 0);

        Movie m1 = new Movie("Sardar Udham", 163, m1_synopsis, "Shoojit Sircar", new ArrayList<>(Arrays.asList("Vicky Kaushal", "Shaun Scott",
                "Stephen Hogan", "Amol Parashar")), "General", "Gold", 40.00, 1, m1_releaseDate, m1_upcomingDate, new int[10][10]);


        for (Movie m :Movie.getMovies()){
            System.out.println(m.getHall());
            System.out.println(m.getUpcomingTime().getTime());
            System.out.println(m.getCast());
            System.out.println(m.getClassification());
            System.out.println(m.getLength());
            System.out.println(m.getTitle());
            System.out.println("--------------");

        }

        JsonAdapter.writeMovies("Movies.json");
        //launch();
    }
}