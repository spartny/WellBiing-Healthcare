package com.wellbiing.wellbiinghealthcare;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {
    @FXML
    private Button loginButton;
    private TextField textfieldUsername;
    private PasswordField passwordfield;

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
    

}
