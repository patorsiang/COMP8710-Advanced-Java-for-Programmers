package kent.co871.concurrency;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;

import java.util.concurrent.atomic.AtomicInteger;

public class Controller {
    @FXML
    private Button btnStart;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label message;

    @FXML
    private void startRunning(ActionEvent actionEvent) {
        Runnable task = () -> {
            var progress = new AtomicInteger(0);
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    progress.set(progress.get() + 10);
                    Platform.runLater(() -> {
                        progressBar.setProgress(progress.get() / 100.0);
                        message.setText("In progress...");
                        if (progress.get() == 100 ) {
                            message.setText("Done.");
                            btnStart.setDisable(true);
                        }
                    });
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        new Thread(task).start();
    }
}
