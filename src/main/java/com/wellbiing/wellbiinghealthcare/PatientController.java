package com.wellbiing.wellbiinghealthcare;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PatientController {
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
        Medication.setStyle("-fx-opacity : 0.0");
        Medication.setDisable(false);

    }


    @FXML
    void LabTest(ActionEvent event) {
        closeAndDisablePanes();
        labTestPane.setBackground(Background.fill(Color.WHITE));
        labTestPane.setStyle("-fx-opacity : 1.0");
        labTestPane.setDisable(false);

    }

    @FXML
    void HomeOpen(ActionEvent event){
        closeAndDisablePanes();
       // overviewPane.setStyle("-fx-background-radius: 50");
        overviewPane.setBackground(Background.fill(Color.WHITE));

        overviewPane.setStyle("-fx-opacity : 1.0");
        overviewPane.setDisable(false);

    }

    @FXML
    public void MedicationOpen(ActionEvent actionEvent) {

        closeAndDisablePanes();
        Medication.setBackground(Background.fill(Color.WHITE));
        Medication.setStyle("-fx-opacity : 1.0");
        Medication.setDisable(true);

    }

}
