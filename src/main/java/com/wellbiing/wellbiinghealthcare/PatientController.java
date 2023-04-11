package com.wellbiing.wellbiinghealthcare;


import com.mysql.cj.xdevapi.Column;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class PatientController implements Initializable {
    @FXML
    private Pane overviewPane;
    @FXML
    private Pane labTestPane;
    @FXML
    private AnchorPane medicationPane;
    @FXML
    private Pane treatmentPane;
    @FXML
    private Pane operationPane;
    @FXML
    private Label username;
    @FXML
    private Label age;
    @FXML
    private Label height;
    @FXML
    private Label bloodGroup;
    @FXML
    private Label weight;
    @FXML
    private Label allergiesLabel;
    @FXML
    private Label medicationLabel;
    @FXML
    private Label treatment;
    @FXML
    private Label checkup;
    @FXML
    private Label idfield;
    @FXML
    private Label genderfield;
    String Username ="Patient1";
    @FXML
    private TableView <LabData> Labtable;
    @FXML
    private TableView<MedicationData> medicineTable;

    public void closeAndDisablePanes(){
        overviewPane.setOpacity(0.0);
        overviewPane.setDisable(true);
        labTestPane.setOpacity(0.0);
        labTestPane.setDisable(true);
        medicationPane.setStyle("-fx-opacity : 0.0");
        medicationPane.setDisable(true);
        treatmentPane.setStyle("-fx-opacity : 0.0");
        treatmentPane.setDisable(true);
        operationPane.setStyle("-fx-opacity : 0.0");
        operationPane.setDisable(true);

    }

    @FXML
    void LabTest(ActionEvent event) {
        closeAndDisablePanes();
        labTestPane.setOpacity(1.0);
        labTestPane.setDisable(false);
    }
    @FXML
    void HomeOpen(ActionEvent event){
        closeAndDisablePanes();
        overviewPane.setOpacity(1.0);
        overviewPane.setDisable(false);

    }

    @FXML
    public void MedicationOpen(ActionEvent actionEvent) {

        closeAndDisablePanes();
        medicationPane.setStyle("-fx-opacity : 1.0");
        medicationPane.setDisable(false);

    }
    @FXML
    public void TreatmentOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        treatmentPane.setStyle("-fx-opacity : 1.0");
        treatmentPane.setDisable(false);
    }
    @FXML
    public void OperationOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        operationPane.setStyle("-fx-opacity : 1.0");
        operationPane.setDisable(false);

    }
    public void setAge(PatientJDBC p){
        age.setText(p.Age);

    }

//   public void setUsername(){
//      LoginController l = new LoginController();
//      Username = l.Username;
//
//   }
   public  void SetHeight(PatientJDBC p){

       height.setText(p.Height);
   }
    public  void SetWeight(PatientJDBC p){

        weight.setText(p.Weight);
    }
    public  void SetBlood_Group(PatientJDBC p){

        bloodGroup.setText(p.Blood_group);
    }
    public void SetAllergies(PatientJDBC p){
        allergiesLabel.setText(p.allergies);

    }
    public void  SetTreatment(PatientJDBC p){
        treatment.setText(p.Treatment);
    }
    public void SetCheckup(PatientJDBC p){

        checkup.setText(p.Checkup);
    }
    public void SetMedication(PatientJDBC p){
        medicationLabel.setText(p.medication);
    }
    public void SetName(PatientJDBC p) {
        username.setText(p.Username);
    }
    public void SetId(PatientJDBC p) {
        idfield.setText(p.Id);
    }
    public void SetGender(PatientJDBC p){
        genderfield.setText(p.gender);
    }

    public  void SetLabData(PatientJDBC p){
        TableColumn<LabData, String> codeColumn = new TableColumn<>("Code");
        TableColumn<LabData, String> costColumn = new TableColumn<>("Cost");
        TableColumn<LabData, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<LabData, String> testTypecolumn = new TableColumn<>("Type");
        TableColumn<LabData, String> testDatecolumn = new TableColumn<>("Date");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_code"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_cost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_description"));
        testTypecolumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_type"));
        testDatecolumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_date"));
        try {
            InsertLabDetailsRows(Labtable);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Labtable.getColumns().add(codeColumn);
        Labtable.getColumns().add(costColumn);
        Labtable.getColumns().add(descriptionColumn);
        Labtable.getColumns().add(testTypecolumn);
        Labtable.getColumns().add(testDatecolumn);
       codeColumn.setMinWidth(84);
       costColumn.setMinWidth(80);
       descriptionColumn.setMinWidth(160);
       testTypecolumn.setMinWidth(115);
       testDatecolumn.setMinWidth(110);


    }
    private void InsertLabDetailsRows(TableView Labtable) throws SQLException, ClassNotFoundException {
        PatientJDBC p = new PatientJDBC();
        p.GetLabDetails(Username,Labtable);


    }

    public  void SetMedicationData(PatientJDBC p){
        TableColumn<MedicationData, String> codeColumn = new TableColumn<>("Code");
        TableColumn<MedicationData, String> costColumn = new TableColumn<>("Cost");
        TableColumn<MedicationData, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<MedicationData, String> medicineTypecolumn = new TableColumn<>("Type");
        TableColumn<MedicationData, String> startDatecolumn = new TableColumn<>("Start_Date");
        TableColumn<MedicationData, String> endDatecolumn = new TableColumn<>("End_Date");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("Medication_code"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("Medication_cost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Medication_description"));
        medicineTypecolumn.setCellValueFactory(new PropertyValueFactory<>("Medication_type"));
        startDatecolumn.setCellValueFactory(new PropertyValueFactory<>("Medication_Sdate"));
        endDatecolumn.setCellValueFactory(new PropertyValueFactory<>("Medication_Edate"));

        try {
            InsertMedicineDetailsRows(medicineTable);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        medicineTable.getColumns().add(codeColumn);
        medicineTable.getColumns().add(costColumn);
        medicineTable.getColumns().add(descriptionColumn);
        medicineTable.getColumns().add(medicineTypecolumn);
        medicineTable.getColumns().add(startDatecolumn);
        medicineTable.getColumns().add(endDatecolumn);
        codeColumn.setMinWidth(50);
        costColumn.setMinWidth(50);
        descriptionColumn.setMinWidth(120);
        medicineTypecolumn.setMinWidth(120);
        startDatecolumn.setMinWidth(100);
        endDatecolumn.setMinWidth(99);


    }
    private void InsertMedicineDetailsRows(TableView medicineTable) throws SQLException, ClassNotFoundException {
        PatientJDBC p = new PatientJDBC();
        p.GetMedicineDetails(Username,medicineTable);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PatientJDBC p = new PatientJDBC();
        //setUsername();
        p.GetInfo(Username);
        setAge(p);
        SetHeight(p);
        SetWeight(p);
        SetBlood_Group(p);
        SetTreatment(p);
        SetCheckup(p);
        SetName(p);
        SetId(p);
        SetGender(p);
        SetAllergies(p);
        SetMedication(p);
        SetLabData(p);
        SetMedicationData(p);



    }
}
