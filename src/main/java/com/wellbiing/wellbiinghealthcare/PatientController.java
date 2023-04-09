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
    private TableColumn <LabData,String> testDatecolumn;

    @FXML
    private TableColumn  <LabData,String> testTypecolumn;

//    @FXML
//    private TableColumn <LabData,String> codeColumn;

    @FXML
    private TableColumn <LabData,String> costColumn;

    @FXML
    private TableColumn <LabData,String> descriptionColumn;

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
    public  void SetColumnData(PatientJDBC p){
       // codeColumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_code"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_cost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_description"));
        testTypecolumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_type"));
        testDatecolumn.setCellValueFactory(new PropertyValueFactory<>("LabTest_date"));
        //Labtable.getItems().addAll(p.labData);
        //



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn codeColumn = new TableColumn("LabTest_code");
        System.out.println(codeColumn.getColumns());
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
        //SetColumnData(p);



    }
}
