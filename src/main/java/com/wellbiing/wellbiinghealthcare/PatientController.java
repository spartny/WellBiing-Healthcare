package com.wellbiing.wellbiinghealthcare;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PatientController {

    @FXML
    private Button LabTest1;

    @FXML
    private Button labTest;

    @FXML
    private Pane overviewPane;
    @FXML
    private Pane labTestPane;
    @FXML
    private AnchorPane Medication;
    public void closeAndDisablePanes(){
        overviewPane.setStyle("-fx-opacity : 0.0");
        overviewPane.setDisable(true);
        labTestPane.setStyle("-fx-opacity : 0.0");
        labTestPane.setDisable(true);

    }


    @FXML
    void LabTest(ActionEvent event) {
        //closeAndDisablePanes();
        overviewPane.setStyle("-fx-opacity : 0.0");
        overviewPane.setDisable(true);
        Medication.setStyle("-fx-opacity : 1.0");
        Medication.setDisable(false);
        labTestPane.setStyle("-fx-opacity : 1.0");
        labTestPane.setDisable(false);

    }
    @FXML
    void HomeOpen(ActionEvent event){
       // closeAndDisablePanes();
        labTestPane.setStyle("-fx-opacity : 0.0");
        labTestPane.setDisable(true);
        overviewPane.setStyle("-fx-opacity : 1.0");
        overviewPane.setDisable(false);

    }

}
