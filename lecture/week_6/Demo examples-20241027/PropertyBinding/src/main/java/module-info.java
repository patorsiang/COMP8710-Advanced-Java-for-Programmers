module kent.co871.binding {
    requires javafx.controls;
    requires javafx.fxml;


    opens kent.co871.propertybinding to javafx.fxml;
    exports kent.co871.propertybinding;
}