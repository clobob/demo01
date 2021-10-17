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
        Movie.setUpcomingMovies(JsonAdapter.getMoviesFromJson("UpcomingMovies.json"));

//        String m1_synopsis = "Ride or Die is a Japanese romance drama film written by Nami Sakkawa and directed by Ryuichi Hiroki, starring Kiko Mizuhara and Honami Sato. The film is based on Ching Nakamura's manga series Gunjō and was released by Netflix on April 15, 2021.";
//
//        Calendar m1_releaseDate = Calendar.getInstance();
//        m1_releaseDate.set(2021, Calendar.APRIL , 15, 0, 0, 0);
//
//        Calendar m1_upcomingDate =  Calendar.getInstance();
//        m1_upcomingDate.set(2021, Calendar.NOVEMBER, 6, 20, 30, 0);
//
//        Movie m1 = new Movie("Ride or Die", 142 , m1_synopsis, "Ryuichi Hiroki", new ArrayList<>(Arrays.asList("Kiko Mizuhara", "Honami Sato",
//                "Yōko Maki", "Shunsuke Tanaka")), "Parental Guidance", "Gold", 40.00, 1, m1_releaseDate, m1_upcomingDate, new int[10][10]);

        for (Movie m :Movie.getUpcomingMovies()){
            System.out.println(m.getHall());
            System.out.println(m.getUpcomingTime().getTime());
            System.out.println(m.getCast());
            System.out.println(m.getClassification());
            System.out.println(m.getLength());
            System.out.println(m.getScreen());
            System.out.println(m.getTitle());
            System.out.println("--------------");

        }

        JsonAdapter.writeMovies("UpcomingMovies.json", Movie.getUpcomingMovies());
        JsonAdapter.writeMovies("Movies.json", Movie.getMovies());
        //launch();
    }
}