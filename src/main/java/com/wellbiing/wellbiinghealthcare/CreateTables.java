package com.wellbiing.wellbiinghealthcare;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.transform.Result;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTables {
    public void SearchVitals(TableView searchTable) {
        TableColumn<PatientInfo, String> patientNameCol = new TableColumn<>("Name");
        TableColumn<VitalsInfo, Float> patientTempCol = new TableColumn<>("Temperature");
        TableColumn<VitalsInfo, Float> patientBPCol = new TableColumn<>("Temperature");
        TableColumn<VitalsInfo, Float> patientHRCol = new TableColumn<>("Blood Pressure");
        TableColumn<VitalsInfo, Float> patientBRCol = new TableColumn<>("Heart Rate");
        TableColumn<VitalsInfo, Float> patientSpO2Col = new TableColumn<>("Breathing Rate");
        TableColumn<VitalsInfo, Date> patientDateCol = new TableColumn<>("Date");

        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientTempCol.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        patientBPCol.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));
        patientHRCol.setCellValueFactory(new PropertyValueFactory<>("heartRate"));
        patientBRCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientSpO2Col.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientDateCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));

        searchTable.getColumns().addAll(patientNameCol, patientTempCol, patientBPCol, patientHRCol,
                patientBRCol, patientSpO2Col, patientDateCol);

        DoctorJDBC jdbc = new DoctorJDBC();

        jdbc.AddVitals(searchTable);

    }

    public void AddVitals(TableView searchTable, TextField searchPatientId) throws SQLException, ClassNotFoundException {
        DoctorJDBC jdbc = new DoctorJDBC();

        int patientId = Integer.parseInt(searchPatientId.getText());

        ResultSet vitals = jdbc.GetVitals(patientId);

        float temperature;
        float bloodPressure;
        float heartRate;
        float breathingRate;
        float testDate;
        float spO2;


        while (vitals.next()){
            
        }
    }
}
