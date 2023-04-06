package com.wellbiing.wellbiinghealthcare;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
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
    private Label allergies;
    @FXML
    private Label medication;
    @FXML
    private Label treatment;
    @FXML
    private Label checkup;




    String Age;
    String Username ="Anuj";
    String Allergies[];
    String Medication[];

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
    public void setAge(){
        PatientJDBC p = new PatientJDBC();
        Age = p.Age(Username);
        age.setText(Age);

    }

   public void setUsername(){
        LoginController l = new LoginController();
        Username = l.Username;
        username.setText(Username);

   }
   public  void SetHeight(){
       PatientJDBC p = new PatientJDBC();
       height.setText(p.Height);
   }
    public  void SetWeight(){
        PatientJDBC p = new PatientJDBC();
        weight.setText(p.Weight);
    }
    public  void SetBlood_Group(){
        PatientJDBC p = new PatientJDBC();
        bloodGroup.setText(p.Blood_group);
    }
    public void SetAllergies(){
        PatientJDBC p = new PatientJDBC();
        for(int i = 0; i< p.allergies.length; i++) {
            Allergies[i] = p.allergies[i];
        }
    }
    public void  SetTreatment(){
        PatientJDBC p = new PatientJDBC();
        treatment.setText(p.Treatment);
    }
    public void SetCheckup(){
        PatientJDBC p = new PatientJDBC();
        checkup.setText(p.Checkup);
    }
    public void SetMedication(){
        PatientJDBC p = new PatientJDBC();
        for(int j = 0; j< p.medication.length; j++) {
           Medication[j] = p.medication[j];
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUsername();
        setAge();
        SetHeight();
        SetWeight();
        SetBlood_Group();
        SetAllergies();
        SetTreatment();
        SetCheckup();
        SetMedication();


    }
}
