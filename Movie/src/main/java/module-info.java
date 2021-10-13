module com.example.movie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.movie to javafx.fxml;
    exports com.example.movie;
}