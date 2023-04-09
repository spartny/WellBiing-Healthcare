package com.wellbiing.wellbiinghealthcare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {



    @FXML
    private AnchorPane allergiesEntryPane;

    @FXML
    private DatePicker patientDOB;

    @FXML
    private DatePicker treatmentEndDate;

    @FXML
    private TextField treatmentCodeField;

    @FXML
    private TextField treatmentTypeField;

    @FXML
    private TextField treatmentDescField;

    @FXML
    private TextField treatmentCostField;

    @FXML
    private TextField patientHeightField;

    @FXML
    private TextField testCodeField;

    @FXML
    private TextField allergyDescriptionField;

    @FXML
    private TextField patientWeightField;

    @FXML
    private TextField patientBloodGroupField;

    @FXML
    private RadioButton allergiesRadio;

    @FXML
    private TextField allergyCodeFIeld;

    @FXML
    private TextField allergyNameField;

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
    private ImageView homeIcon;

    @FXML
    private AnchorPane homePane;

    @FXML
    private AnchorPane labTestEntryPane;

    @FXML
    private RadioButton labTestRadio;

    @FXML
    private Button logOutButton;

    @FXML
    private TextField medicationCodeField;

    @FXML
    private TextField medicationCost;

    @FXML
    private TextField medicationDescription;

    @FXML
    private DatePicker medicationEndDate;

    @FXML
    private AnchorPane medicationEntryPane;

    @FXML
    private RadioButton medicationRadio;

    @FXML
    private TextField medicationTypeField;

    @FXML
    private Button newPatientButton;

    @FXML
    private Button newPatientConfirmButton;

    @FXML
    private AnchorPane newPatientPane;

    @FXML
    private TextField operationCodeField;

    @FXML
    private TextField operationCostField;

    @FXML
    private TextField operationDescriptionField;

    @FXML
    private AnchorPane operationEntryPane;

    @FXML
    private RadioButton operationRadio;

    @FXML
    private TextField operationTypeField;

    @FXML
    private TextField patientContactField;

    @FXML
    private Button patientEntryButton;

    @FXML
    private Button patientEntryConfirm;

    @FXML
    private ToggleGroup patientEntryGroup;

    @FXML
    private TextField patientEntryIdField;

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
    private RadioButton searchAllergiesRadio;

    @FXML
    private Button searchConfirmButton;

    @FXML
    private RadioButton searchLabTestRadio;

    @FXML
    private RadioButton searchMedicationRadio;

    @FXML
    private RadioButton searchOperationRadio;

    @FXML
    private ToggleGroup searchPatientGroup;

    @FXML
    private TextField searchPatientId;

    @FXML
    private AnchorPane searchPatientPane;

    @FXML
    private RadioButton searchTreatmentRadio;

    @FXML
    private RadioButton searchVitalsRadio;

    @FXML
    private TextField testCost;

    @FXML
    private TextField testDescription;

    @FXML
    private ComboBox<?> testSelect;

    @FXML
    private TextField testTypeField;

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
    private TextField vitalsBpField;

    @FXML
    private TextField vitalsBrField;

    @FXML
    private AnchorPane vitalsEntryPane;

    @FXML
    private TextField vitalsHrField;

    @FXML
    private RadioButton vitalsRadio;

    @FXML
    private TextField vitalsSpo2FIeld;

    @FXML
    private TextField vitalsTempFIeld;

    @FXML
    private TableView curPatientTable;

    @FXML
    private TableView searchTable;

    @FXML
    private TextField patientStateField;

    @FXML
    private TextField patientCityField;

    @FXML
    private TextField patientStreetField;

    @FXML
    private RadioButton patientGenderMale;

    @FXML
    private RadioButton patientGenderFemale;

    @FXML
    private Label patientCountLabel;


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

        Date curDate = Date.valueOf(LocalDate.now());



        if (selectedToggle == vitalsRadio){
            jdbc.EnterVitals(patientId, vitalsTempFIeld.getText(), vitalsSpo2FIeld.getText(), vitalsBpField.getText(),
                    vitalsHrField.getText(), vitalsBrField.getText(), curDate);
        }
        if (selectedToggle == labTestRadio){
            jdbc.EnterTest(patientId, testCodeField.getText(), testCost.getText(), testDescription.getText(),
                    testTypeField.getText(), curDate);
        }

        if (selectedToggle == medicationRadio){
            jdbc.EnterMedication(patientId, medicationCodeField.getText(), medicationCost.getText(), medicationDescription.getText(),
                    medicationTypeField.getText(), curDate, Date.valueOf(medicationEndDate.getValue()));
        }
        if (selectedToggle == treatmentRadio){
            jdbc.EnterTreatments(patientId, treatmentCodeField.getText(), treatmentCostField.getText(), treatmentDescField.getText(),
                    treatmentTypeField.getText(), curDate,  Date.valueOf(treatmentEndDate.getValue()));
        }
        if (selectedToggle == operationRadio){
            jdbc.EnterOperation(patientId, operationCodeField.getText(), operationCostField.getText(), operationDescriptionField.getText(),
                    operationTypeField.getText(), curDate);
        }
        if (selectedToggle == allergiesRadio){
            jdbc.EnterAllergies(patientId, allergyCodeFIeld.getText(), allergyNameField.getText(), allergyDescriptionField.getText(),
                    curDate);
        }
    }

    public void NewPatientConfirm(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Toggle selectedToggle = patientGenderGroup.getSelectedToggle();
        String patientId = patientIdField.getText();
        DoctorJDBC jdbc = new DoctorJDBC();

        String gender;
        if (selectedToggle == patientGenderMale){
            gender = "M";
        }
        else {
            gender = "F";
        }
        Date dob = Date.valueOf(patientDOB.getValue());

        jdbc.EnterNewPatient(patientId, patientNameField.getText(), dob, gender, patientHeightField.getText(), patientWeightField.getText(),
                patientBloodGroupField.getText(), patientContactField.getText(), patientStateField.getText(), patientCityField.getText(),
                patientStreetField.getText());

    }

    public void CurrentPatientTable(){
        TableColumn<PatientInfo, Integer> patientIdCol = new TableColumn<>("Patient ID");
        TableColumn<PatientInfo, String> patientNameCol = new TableColumn<>("Name");
        TableColumn<PatientInfo, String> patientContactCol = new TableColumn<>("Contact No.");
        TableColumn<PatientInfo, Date> patientDateCol = new TableColumn<>("Last Visit");

        patientIdCol.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientContactCol.setCellValueFactory(new PropertyValueFactory<>("patientContact"));
        patientDateCol.setCellValueFactory(new PropertyValueFactory<>("patientLastVisit"));

        patientIdCol.setMinWidth(50);
        patientNameCol.setMinWidth(250);
        patientContactCol.setMinWidth(150);

        try {
            InsertCurPatientRows(curPatientTable);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        curPatientTable.getColumns().add(patientIdCol);
        curPatientTable.getColumns().add(patientNameCol);
        curPatientTable.getColumns().add(patientContactCol);
        curPatientTable.getColumns().add(patientDateCol);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CurrentPatientTable();
    }

    private void InsertCurPatientRows(TableView curPatientTable) throws SQLException, ClassNotFoundException {
        DoctorJDBC jdbc = new DoctorJDBC();
        int patientCount = jdbc.GetPatientCount();

        patientCountLabel.setText(String.valueOf(patientCount));

        jdbc.GetPatients(curPatientTable);

    }

    public void SearchPatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        searchTable.getItems().clear();
        searchTable.getColumns().clear();
        Toggle selectedToggle = searchPatientGroup.getSelectedToggle();
        CreateTables createTables = new CreateTables();

        if (selectedToggle == searchVitalsRadio) {
            createTables.SearchVitals(searchTable);
            createTables.AddVitals(searchTable, searchPatientId);
        }

        if (selectedToggle == searchMedicationRadio){
            createTables.SearchMedication(searchTable);
            createTables.AddMedication(searchTable, searchPatientId);
        }

        if (selectedToggle == searchTreatmentRadio){
            createTables.SearchTreatment(searchTable);
            createTables.AddTreatment(searchTable, searchPatientId);
        }

        if (selectedToggle == searchAllergiesRadio){
            createTables.SearchAllergy(searchTable);
            createTables.AddAllergy(searchTable, searchPatientId);
        }

    }
}

