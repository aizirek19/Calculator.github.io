module com.example.javafxcalculatormav {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxcalculatormav to javafx.fxml;
    exports com.example.javafxcalculatormav;
}