// Cohen Gallagher - 3/7/25

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.List;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public Button btnExit;
    public Button btnSubmit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtInitial;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private TextField txtZipcode;
    @FXML
    private TextField txtState;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtPlanType;
    @FXML
    private Label lblSuccess;

    // Submit button, inputs books into the database by parsing them from text boxes
    @FXML
    private void submitNewBook() {
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String initial = txtInitial.getText().trim();
        String phoneNumber = txtPhoneNumber.getText().trim();
        int zipcode = Integer.parseInt(txtZipcode.getText().trim());
        String state = txtState.getText().trim();
        String city = txtCity.getText().trim();
        String planType = txtPlanType.getText().trim();
        txtFirstName.clear();
        txtLastName.clear();
        txtInitial.clear();
        txtPhoneNumber.clear();
        txtZipcode.clear();
        txtState.clear();
        txtCity.clear();
        txtPlanType.clear();
        //Try to save client to database

        try {
            Client newClient = new Client(firstName, lastName, initial, phoneNumber, zipcode, state, city, planType);
            List<String> errors = ClientValidator.validateClient(newClient);
            boolean isSaved = ClientDatabaseManager.insertClient(newClient);

            if (isSaved) {
                lblSuccess.setTextFill(Color.DARKGREEN);
                lblSuccess.setText("Success!");
            } else {
                System.out.println("Error!");
                lblSuccess.setTextFill(Color.INDIANRED);
                lblSuccess.setText("Failed to insert client.");
            }
        } catch (Exception e) {
            lblSuccess.setTextFill(Color.INDIANRED);
            lblSuccess.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @FXML
    private void exitApplication() {
        Platform.exit();
    }
}