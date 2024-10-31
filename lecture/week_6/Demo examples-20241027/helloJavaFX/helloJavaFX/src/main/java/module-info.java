module kent.co871.hellojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens kent.co871.hellojavafx to javafx.fxml;
    exports kent.co871.hellojavafx;
}