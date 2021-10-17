module com.example.movie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires fastjson;
    requires java.sql;

    opens com.example.movie to javafx.fxml, fastjson;
    opens com.example.movie.backend to fastjson;
    exports com.example.movie;
}