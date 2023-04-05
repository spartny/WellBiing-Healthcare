package com.wellbiing.wellbiinghealthcare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class DoctorController {

    @FXML
    private Button delPatientButton;

    @FXML
    private Button homeButton;

    @FXML
    private AnchorPane homePane;

    @FXML
    private ComboBox<ArrayList<String>> labTestSelect;

    @FXML
    private Button newPatientButton;

    @FXML
    private AnchorPane newPatientPane;

    @FXML
    private TextField patientAddressField;

    @FXML
    private TextField patientContactField;

    @FXML
    private DatePicker patientDOBField;

    @FXML
    private Button patientEntryButton;

    @FXML
    private Button patientEntryConfirm;

    @FXML
    private AnchorPane patientEntryPane;

    @FXML
    private TextField patientIdField;

    @FXML
    private TextField patientNameField;

    @FXML
    private TextField patientPasswordField;

    @FXML
    private Button signoutButton;

    @FXML
    private Button updPatientButton;

    @FXML
    private Button updPatientButton1;

    @FXML
    private Button newPatientConfirm;


    @FXML
    void ButtonHoverEnd(MouseEvent event) {
        Button b = (Button)event.getSource();
        b.setStyle("-fx-background-color: #ffffff");
    }

    @FXML
    void ButtonHoverStart(MouseEvent event) {
        Button b = (Button) event.getSource();
        b.setStyle("-fx-font-size: 30");
        b.setStyle("-fx-background-color: #a4adb7");
//        b.setStyle("fx-background-image: url('assets\\home.png')");
    }

    public void closeAndDisablePanes(){
        homePane.setOpacity(0);
        homePane.setDisable(true);
        newPatientPane.setOpacity(0);
        newPatientPane.setDisable(true);
        patientEntryPane.setOpacity(0);
        homePane.setDisable(true);
    }

    public void HomeOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        homePane.setDisable(false);
        homePane.setOpacity(1);
    }

    public void NewPatientOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        newPatientPane.setDisable(false);
        newPatientPane.setOpacity(1);
    }

    public void PatientEntryOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        patientEntryPane.setDisable(false);
        patientEntryPane.setOpacity(10);
    }
}

