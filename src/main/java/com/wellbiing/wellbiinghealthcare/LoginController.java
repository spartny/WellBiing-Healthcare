package com.wellbiing.wellbiinghealthcare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button login;
    private TextField username;
    private PasswordField password;
    private Label invalid;

    @FXML
    void ButtonHoverEnd(MouseEvent event) {
        Button b = (Button)event.getSource();
        b.setStyle("-fx-background-color: #ffffff");
        b.setStyle(("-fx-background-radius: 50px"));
    }

    @FXML
    void ButtonHoverStart(MouseEvent event) {
        Button b = (Button)event.getSource();
        b.setStyle("-fx-background-color: #a4adb7");
        b.setStyle(("-fx-background-radius: 50px"));
    }
    private String Username;
    private String Password;
    @FXML
    void onLoginButtonClick(ActionEvent event) throws IOException {
        checkCredentials();
    }
    private void checkCredentials() throws IOException {
        if ((username.getText().isEmpty()) && (password.getText().isEmpty())){
            invalid.setText("Invalid Credentials");
        }
//        Username = username.getText().toString();
//        Password = password.getText().toString();
        WellBiingApplication w = new WellBiingApplication();


    }
}
