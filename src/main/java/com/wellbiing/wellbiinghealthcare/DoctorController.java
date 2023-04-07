package com.wellbiing.wellbiinghealthcare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorController {

    @FXML
    private ImageView homeIcon;

    @FXML
    private AnchorPane allergiesEntryPane;

    @FXML
    private RadioButton allergiesRadio;

    @FXML
    private Button delPatientButton;

    @FXML
    private TextField deletePateintId;

    @FXML
    private Button deletePatientConfirmButton1;

    @FXML
    private DatePicker deletePatientDate;

    @FXML
    private AnchorPane deletePatientPane;

    @FXML
    private Button entrySelectButton;

    @FXML
    private Button homeButton;

    @FXML
    private AnchorPane homePane;

    @FXML
    private AnchorPane labTestEntryPane;

    @FXML
    private RadioButton labTestRadio;

    @FXML
    private ComboBox<?> labTestSelect;

    @FXML
    private Button logOutButton;

    @FXML
    private AnchorPane medicationEntryPane;

    @FXML
    private RadioButton medicationRadio;

    @FXML
    private Button newPatientButton;

    @FXML
    private Button newPatientConfirmButton;

    @FXML
    private AnchorPane newPatientPane;

    @FXML
    private AnchorPane operationEntryPane;

    @FXML
    private RadioButton operationRadio;

    @FXML
    private TextField patientAddressField;

    @FXML
    private TextField patientContactField;

    @FXML
    private Button patientEntryButton;

    @FXML
    private Button patientEntryConfirm;

    @FXML
    private ToggleGroup patientEntryGroup;

    @FXML
    private AnchorPane patientEntryPane;

    @FXML
    private ToggleGroup patientGenderGroup;

    @FXML
    private TextField patientIdField;

    @FXML
    private TextField patientNameField;

    @FXML
    private TextField patientPasswordField;

    @FXML
    private Button searchConfirmButton;

    @FXML
    private TextField searchPatientId;

    @FXML
    private AnchorPane searchPatientPane;

    @FXML
    private AnchorPane treatmentEntryPane;

    @FXML
    private RadioButton treatmentRadio;

    @FXML
    private Button updPatientButton;

    @FXML
    private Button updPatientButton1;

    @FXML
    private Button updatePatientConfirmButton;

    @FXML
    private DatePicker updatePatientDate;

    @FXML
    private TextField updatePatientId;

    @FXML
    private AnchorPane updatePatientPane;

    @FXML
    private AnchorPane vitalsEntryPane;

    @FXML
    private RadioButton vitalsRadio;

    @FXML
    private TextField patientEntryIdField;

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
        updatePatientPane.setOpacity(0);
        updatePatientPane.setDisable(true);
        searchPatientPane.setOpacity(0);
        searchPatientPane.setDisable(true);
        deletePatientPane.setOpacity(0);
        deletePatientPane.setDisable(true);
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
        patientEntryPane.setOpacity(1);
    }

    public void SearchPatientOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        searchPatientPane.setDisable(false);
        searchPatientPane.setOpacity(1);
    }

    public void UpdatePatientOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        updatePatientPane.setDisable(false);
        updatePatientPane.setOpacity(1);
    }
    public void DeletePatientOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        deletePatientPane.setDisable(false);
        deletePatientPane.setOpacity(1);
    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        WellBiingApplication wa = new WellBiingApplication();
        wa.changeScene("login.fxml");
    }

    public void closeEntryPanes(){
        vitalsEntryPane.setOpacity(0);
        vitalsEntryPane.setDisable(true);
        labTestEntryPane.setOpacity(0);
        labTestEntryPane.setDisable(true);
        allergiesEntryPane.setOpacity(0);
        allergiesEntryPane.setDisable(true);
        medicationEntryPane.setOpacity(0);
        medicationEntryPane.setDisable(true);
        treatmentEntryPane.setOpacity(0);
        treatmentEntryPane.setDisable(true);
        operationEntryPane.setOpacity(0);
        operationEntryPane.setDisable(true);
    }
    public void SelectEntry(ActionEvent actionEvent) {
        Toggle selectedToggle = patientEntryGroup.getSelectedToggle();
        if (selectedToggle == vitalsRadio){
            closeEntryPanes();
            vitalsEntryPane.setDisable(false);
            vitalsEntryPane.setOpacity(1);
        }
        if (selectedToggle == labTestRadio){
            closeEntryPanes();
            labTestEntryPane.setDisable(false);
            labTestEntryPane.setOpacity(1);
        }
        if (selectedToggle == medicationRadio){
            closeEntryPanes();
            medicationEntryPane.setDisable(false);
            medicationEntryPane.setOpacity(1);
        }
        if (selectedToggle == treatmentRadio){
            closeEntryPanes();
            treatmentEntryPane.setDisable(false);
            treatmentEntryPane.setOpacity(1);
        }
        if (selectedToggle == operationRadio){
            closeEntryPanes();
            operationEntryPane.setDisable(false);
            operationEntryPane.setOpacity(1);
        }
        if (selectedToggle == allergiesRadio){
            closeEntryPanes();
            allergiesEntryPane.setDisable(false);
            allergiesEntryPane.setOpacity(1);
        }

    }

    public void PatientEntryConfirm(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Toggle selectedToggle = patientEntryGroup.getSelectedToggle();
        DoctorJDBC jdbc = new DoctorJDBC();
        String patientId = patientEntryIdField.getText();


        if (selectedToggle == vitalsRadio){
            jdbc.EnterVitals();
        }
        if (selectedToggle == labTestRadio){
            jdbc.EnterTest();
        }
        if (selectedToggle == medicationRadio){
            jdbc.EnterMedication();
        }
        if (selectedToggle == treatmentRadio){
            jdbc.EnterTreatments();
        }
        if (selectedToggle == operationRadio){
            jdbc.EnterOperation();
        }
        if (selectedToggle == allergiesRadio){
            jdbc.EnterAllergies();
        }
    }

}

