module kent.co871.concurrency {
    requires javafx.controls;
    requires javafx.fxml;


    opens kent.co871.concurrency to javafx.fxml;
    exports kent.co871.concurrency;
}