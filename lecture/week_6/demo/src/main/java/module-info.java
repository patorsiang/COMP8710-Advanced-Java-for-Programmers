module kent.co871.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens kent.co871.demo to javafx.fxml;
    exports kent.co871.demo;
}