package kent.co871.simplebankmvc;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField txbName;
    @FXML
    private TextField txbBalance;
    @FXML
    private Button btnDelete;
    @FXML
    private ListView<Account> listView;
    @FXML
    private Label lblAsset;
    @FXML
    private Label minAsset;
    @FXML
    private Label maxAsset;
    @FXML
    private Label avgAsset;

    private final Model model;

    private String name;
    private int balance;

    public Controller() {

        model = new Model();

        // Listen to any changes in the list of accounts, so we can
        // update both the listView and the current assets
        model.addAccountsListener(e -> {
            listView.setItems(model.getCustomers());
            lblAsset.setText(String.valueOf(model.bankCashAssets()));
            minAsset.setText(String.valueOf(model.minBankCashAssets()));
            maxAsset.setText(String.valueOf(model.maxBankCashAssets()));
            avgAsset.setText(String.valueOf(model.avgBankCashAssets()));
            if (model.bankSize() == 0) {
                btnDelete.setDisable(true);
            }
        });
    }

    public void show(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
            primaryStage.setTitle("A Simple Bank");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnAddHandler() {
        name = txbName.getText();

        try {
            balance = Integer.parseInt(txbBalance.getText());

            if (balance > 0) {
                model.addAccount(name, balance);
            } else {
                throw new NumberFormatException("Balance must be a positive integer!");
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Balance must be a positive integer!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void btnDeleteHandler() {
        Account a = listView.getSelectionModel().getSelectedItem();
        if (a != null) {
            model.removeAccount(a);
        }
    }

    @FXML
    private void selectHandler() {
        // Activate delete button iff an account is selected
        if (listView.getSelectionModel().selectedIndexProperty().getValue() == -1) {
            btnDelete.setDisable(true);
        } else {
            btnDelete.setDisable(false);
        }
    }
}