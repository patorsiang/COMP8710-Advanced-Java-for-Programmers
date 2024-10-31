package kent.co871.propertybinding;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Pane container;
    @FXML
    private Circle circle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var widthProp = container.widthProperty();
        var heightProp = container.heightProperty();
        var minProp = widthProp.get() < heightProp.get() ? widthProp : heightProp;

        circle.radiusProperty().bind(minProp.divide(5));
        circle.centerXProperty().bind(widthProp.divide(2));
        circle.centerYProperty().bind(heightProp.divide(2));
    }
}
