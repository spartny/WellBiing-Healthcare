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
        TableColumn<VitalsInfo, String> patientNameCol = new TableColumn<>("Name");
        TableColumn<VitalsInfo, Float> patientTempCol = new TableColumn<>("Temperature");
        TableColumn<VitalsInfo, Float> patientBPCol = new TableColumn<>("Blood Pressure");
        TableColumn<VitalsInfo, Float> patientHRCol = new TableColumn<>("Heart Rate");
        TableColumn<VitalsInfo, Float> patientBRCol = new TableColumn<>("Breathing Rate");
        TableColumn<VitalsInfo, Float> patientSpO2Col = new TableColumn<>("SpO2");
        TableColumn<VitalsInfo, Date> patientDateCol = new TableColumn<>("Date");

        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientTempCol.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        patientBPCol.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));
        patientHRCol.setCellValueFactory(new PropertyValueFactory<>("heartRate"));
        patientBRCol.setCellValueFactory(new PropertyValueFactory<>("breathingRate"));
        patientSpO2Col.setCellValueFactory(new PropertyValueFactory<>("spO2"));
        patientDateCol.setCellValueFactory(new PropertyValueFactory<>("testDate"));

        searchTable.getColumns().addAll(patientNameCol, patientTempCol, patientBPCol, patientHRCol,
                patientBRCol, patientSpO2Col, patientDateCol);

    }

    public void AddVitals(TableView searchTable, TextField searchPatientId) throws SQLException, ClassNotFoundException {
        DoctorJDBC jdbc = new DoctorJDBC();

        int patientId = Integer.parseInt(searchPatientId.getText());

        ResultSet vitals = jdbc.GetVitals(patientId);
        String patientName = jdbc.GetName(patientId);
        float temperature;
        float bloodPressure;
        float heartRate;
        float breathingRate;
        Date testDate;
        float spO2;


        while (vitals.next()) {
            temperature = vitals.getFloat(2);
            bloodPressure = vitals.getFloat(3);
            heartRate = vitals.getFloat(4);
            breathingRate = vitals.getFloat(5);
            testDate = vitals.getDate(6);
            spO2 = vitals.getFloat(7);

            searchTable.getItems().add(new VitalsInfo(patientName, temperature, bloodPressure, heartRate, breathingRate, testDate, spO2));
        }

    }

    public void SearchMedication(TableView searchTable) {
        TableColumn<MedicationInfo, String> patientNameCol = new TableColumn<>("Name");
        TableColumn<MedicationInfo, Integer> medicationCodeCol = new TableColumn<>("Code");
        TableColumn<MedicationInfo, String> medicationCostCol = new TableColumn<>("Cost");
        TableColumn<MedicationInfo, String> medicationDescCol = new TableColumn<>("Description");
        TableColumn<MedicationInfo, String> medicationTypeCol = new TableColumn<>("Type");
        TableColumn<MedicationInfo, Date> medicationSDateCol = new TableColumn<>("Start Date");
        TableColumn<MedicationInfo, Date> medicationEDateCol = new TableColumn<>("End Date");

        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        medicationCodeCol.setCellValueFactory(new PropertyValueFactory<>("medicationCode"));
        medicationCostCol.setCellValueFactory(new PropertyValueFactory<>("medicationCost"));
        medicationDescCol.setCellValueFactory(new PropertyValueFactory<>("medicationDesc"));
        medicationTypeCol.setCellValueFactory(new PropertyValueFactory<>("medicationType"));
        medicationSDateCol.setCellValueFactory(new PropertyValueFactory<>("medicationSDate"));
        medicationEDateCol.setCellValueFactory(new PropertyValueFactory<>("medicationEDate"));

        searchTable.getColumns().addAll(patientNameCol, medicationCodeCol, medicationCostCol, medicationDescCol,
                medicationTypeCol, medicationSDateCol, medicationEDateCol);

    }

    public void AddMedication(TableView searchTable, TextField searchPatientId) throws SQLException, ClassNotFoundException {
        DoctorJDBC jdbc = new DoctorJDBC();

        int patientId = Integer.parseInt(searchPatientId.getText());

        ResultSet medication = jdbc.GetMedication(patientId);
        String patientName = jdbc.GetName(patientId);

        int medicationCode;
        String medicationCost;
        String medicationDesc;
        String medicationType;
        Date medicationSDate;
        Date medicationEDate;


        while (medication.next()) {
            medicationCode = medication.getInt(2);
            medicationCost = medication.getString(3);
            medicationDesc = medication.getString(4);
            medicationType = medication.getString(5);
            medicationSDate = medication.getDate(6);
            medicationEDate = medication.getDate(7);

            searchTable.getItems().add(new MedicationInfo(patientName, medicationCode, medicationCost,
                    medicationDesc, medicationType, medicationSDate, medicationEDate));
        }
    }

    public void SearchTreatment(TableView searchTable) {
        TableColumn<TreatmentInfo, String> patientNameCol = new TableColumn<>("Name");
        TableColumn<TreatmentInfo, Integer> treatmentCodeCol = new TableColumn<>("Code");
        TableColumn<TreatmentInfo, String> treatmentCostCol = new TableColumn<>("Cost");
        TableColumn<TreatmentInfo, String> treatmentDescCol = new TableColumn<>("Description");
        TableColumn<TreatmentInfo, String> treatmentTypeCol = new TableColumn<>("Type");
        TableColumn<TreatmentInfo, Date> treatmentSDateCol = new TableColumn<>("Start Date");
        TableColumn<TreatmentInfo, Date> treatmentEDateCol = new TableColumn<>("End Date");

        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        treatmentCodeCol.setCellValueFactory(new PropertyValueFactory<>("treatmentCode"));
        treatmentCostCol.setCellValueFactory(new PropertyValueFactory<>("treatmentCost"));
        treatmentDescCol.setCellValueFactory(new PropertyValueFactory<>("treatmentDesc"));
        treatmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("treatmentType"));
        treatmentSDateCol.setCellValueFactory(new PropertyValueFactory<>("treatmentSDate"));
        treatmentEDateCol.setCellValueFactory(new PropertyValueFactory<>("treatmentEDate"));

        searchTable.getColumns().addAll(patientNameCol, treatmentCodeCol, treatmentCostCol, treatmentDescCol,
                treatmentTypeCol, treatmentSDateCol, treatmentEDateCol);
    }

    public void AddTreatment(TableView searchTable, TextField searchPatientId) throws SQLException, ClassNotFoundException {
        DoctorJDBC jdbc = new DoctorJDBC();

        int patientId = Integer.parseInt(searchPatientId.getText());

        ResultSet treatments = jdbc.GetTreatment(patientId);
        String patientName = jdbc.GetName(patientId);

        int treatmentCode;
        String treatmentCost;
        String treatmentDesc;
        String treatmentType;
        Date treatmentSDate;
        Date treatmentEDate;


        while (treatments.next()) {
            treatmentCode = treatments.getInt(2);
            treatmentCost = treatments.getString(3);
            treatmentDesc = treatments.getString(4);
            treatmentType = treatments.getString(5);
            treatmentSDate = treatments.getDate(6);
            treatmentEDate = treatments.getDate(7);

            searchTable.getItems().add(new TreatmentInfo(patientName, treatmentCode, treatmentCost,
                    treatmentDesc, treatmentType, treatmentSDate, treatmentEDate));
        }
    }

    public void AddAllergy(TableView searchTable, TextField searchPatientId) throws SQLException, ClassNotFoundException {
        DoctorJDBC jdbc = new DoctorJDBC();

        int patientId = Integer.parseInt(searchPatientId.getText());

        ResultSet allergies = jdbc.GetAllergy(patientId);
        String patientName = jdbc.GetName(patientId);

        int allergyCode;
        String allergyName;
        String allergyDesc;
        Date allergyDate;


        while (allergies.next()) {
            allergyCode = allergies.getInt(2);
            allergyName = allergies.getString(3);
            allergyDesc = allergies.getString(4);
            allergyDate = allergies.getDate(5);

            searchTable.getItems().add(new AllergyInfo(patientName, allergyCode, allergyName,
                    allergyDesc, allergyDate));
        }
    }

    public void SearchAllergy(TableView searchTable) {
        TableColumn<AllergyInfo, String> patientNameCol = new TableColumn<>("Patient Name");
        TableColumn<AllergyInfo, Integer> allergyCodeCol = new TableColumn<>("Code");
        TableColumn<AllergyInfo, String> allergyNameCol = new TableColumn<>("Name");
        TableColumn<AllergyInfo, String> allergyDescCol = new TableColumn<>("Description");
        TableColumn<AllergyInfo, Date> allergyTypeCol = new TableColumn<>("Date");

        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        allergyCodeCol.setCellValueFactory(new PropertyValueFactory<>("allergyCode"));
        allergyNameCol.setCellValueFactory(new PropertyValueFactory<>("allergyName"));
        allergyDescCol.setCellValueFactory(new PropertyValueFactory<>("allergyDesc"));
        allergyTypeCol.setCellValueFactory(new PropertyValueFactory<>("allergyDate"));

        searchTable.getColumns().addAll(patientNameCol, allergyCodeCol, allergyNameCol, allergyDescCol,
                allergyTypeCol);
    }
}