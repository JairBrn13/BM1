module com.example.bm1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jssc;


    opens com.example.bm1 to javafx.fxml;
    exports com.example.bm1;
}