module kent.co871.simplebankmvc {
    requires javafx.controls;
    requires javafx.fxml;


    opens kent.co871.simplebankmvc to javafx.fxml;
    exports kent.co871.simplebankmvc;
}