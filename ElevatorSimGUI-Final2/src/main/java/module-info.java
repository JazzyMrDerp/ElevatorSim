module org.example.elevatorsimguifinal2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.elevatorsimguifinal2 to javafx.fxml;
    exports org.example.elevatorsimguifinal2;
}