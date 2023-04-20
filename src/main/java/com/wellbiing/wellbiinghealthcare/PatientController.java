package com.wellbiing.wellbiinghealthcare;


import com.mysql.cj.xdevapi.Column;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
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
    private Pane profilePane;
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
    String Username;
    @FXML
    private TableView <LabInfo> Labtable;
    @FXML
    private TableView<MedicationInfo> medicineTable;
    @FXML
    private TableView<OperationInfo> operationTable;
    @FXML
    private  TableView<TreatmentInfo> treatmentTable;
    @FXML
    private  TableView<LabInfo> recentLabTest;
    @FXML
    private TableView<OperationInfo> recentOperation;
    @FXML
    private  TableView<TreatmentInfo> recentTreatment;

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
        profilePane.setStyle("-fx-opacity : 0.0");
        profilePane.setDisable(true);

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

    @FXML
    public void ProfileOpen(ActionEvent actionEvent) {
        closeAndDisablePanes();
        profilePane.setStyle("-fx-opacity : 1.0");
        profilePane.setDisable(false);

    }


    @FXML
    void ButtonHoverEnd(MouseEvent event) {
        Button b = (Button)event.getSource();
        b.setStyle("-fx-background-color: #ffffff");
    }

    @FXML
    void ButtonHoverStart(MouseEvent event) {
        Button b = (Button) event.getSource();

        b.setStyle("-fx-background-color: #a4adb7");
    }

    public void SignOut(ActionEvent actionEvent) throws IOException {
        WellBiingApplication wa = new WellBiingApplication();
        wa.changeScene("login.fxml");
    }

    public void setAge(PatientJDBC p){
        age.setText(p.Age);

    }

   public void setUsername(){
      LoginController l = new LoginController();
      Username = l.Username;


   }
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
        TableColumn<LabInfo, String> codeColumn = new TableColumn<>("Code");
        TableColumn<LabInfo, String> costColumn = new TableColumn<>("Cost");
        TableColumn<LabInfo, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<LabInfo, String> testTypecolumn = new TableColumn<>("Type");
        TableColumn<LabInfo, String> testDatecolumn = new TableColumn<>("Date");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("LabCode"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("LabCost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("LabDesc"));
        testTypecolumn.setCellValueFactory(new PropertyValueFactory<>("LabType"));
        testDatecolumn.setCellValueFactory(new PropertyValueFactory<>("LabDate"));
        try {
            InsertLabDetailsRows(Labtable,p);
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
    private void InsertLabDetailsRows(TableView Labtable,PatientJDBC p) throws SQLException, ClassNotFoundException {

        p.GetLabDetails(Username,Labtable);

    }

    public  void SetRecentLabData(PatientJDBC p){
        TableColumn<LabInfo, String> codeColumn = new TableColumn<>("Code");
        TableColumn<LabInfo, String> costColumn = new TableColumn<>("Cost");
        TableColumn<LabInfo, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<LabInfo, String> testTypecolumn = new TableColumn<>("Type");
        TableColumn<LabInfo, String> testDatecolumn = new TableColumn<>("Date");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("LabCode"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("LabCost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("LabDesc"));
        testTypecolumn.setCellValueFactory(new PropertyValueFactory<>("LabType"));
        testDatecolumn.setCellValueFactory(new PropertyValueFactory<>("LabDate"));
        try {
            InsertRecentLabDetailRow(recentLabTest,p);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        recentLabTest.getColumns().add(codeColumn);
        recentLabTest.getColumns().add(costColumn);
        recentLabTest.getColumns().add(descriptionColumn);
        recentLabTest.getColumns().add(testTypecolumn);
        recentLabTest.getColumns().add(testDatecolumn);

        codeColumn.setMinWidth(84);
        costColumn.setMinWidth(80);
        descriptionColumn.setMinWidth(160);
        testTypecolumn.setMinWidth(115);
        testDatecolumn.setMinWidth(110);


    }
    private void InsertRecentLabDetailRow(TableView recentLabTest,PatientJDBC p) throws SQLException, ClassNotFoundException {
         p.GetRecentLabDetail(Username,recentLabTest);


    }

    public  void SetMedicationData(PatientJDBC p){
        TableColumn<MedicationInfo, String> codeColumn = new TableColumn<>("Code");
        TableColumn<MedicationInfo, String> costColumn = new TableColumn<>("Cost");
        TableColumn<MedicationInfo, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<MedicationInfo, String> medicineTypecolumn = new TableColumn<>("Type");
        TableColumn<MedicationInfo, String> startDatecolumn = new TableColumn<>("Start_Date");
        TableColumn<MedicationInfo, String> endDatecolumn = new TableColumn<>("End_Date");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("MedicationCode"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("MedicationCost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("MedicationDesc"));
        medicineTypecolumn.setCellValueFactory(new PropertyValueFactory<>("MedicationType"));
        startDatecolumn.setCellValueFactory(new PropertyValueFactory<>("MedicationSDate"));
        endDatecolumn.setCellValueFactory(new PropertyValueFactory<>("MedicationEDate"));

        try {
            InsertMedicineDetailsRows(medicineTable,p);
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
    private void InsertMedicineDetailsRows(TableView medicineTable,PatientJDBC p) throws SQLException, ClassNotFoundException {

        p.GetMedicineDetails(Username,medicineTable);


    }

    public  void SetOperationData(PatientJDBC p){
        TableColumn<OperationInfo, String> codeColumn = new TableColumn<>("Code");
        TableColumn<OperationInfo, String> costColumn = new TableColumn<>("Cost");
        TableColumn<OperationInfo, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<OperationInfo, String> operationTypecolumn = new TableColumn<>("Type");
        TableColumn<OperationInfo, String> Datecolumn = new TableColumn<>("Date");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("opCode"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("opCost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("opDesc"));
        operationTypecolumn.setCellValueFactory(new PropertyValueFactory<>("opType"));
        Datecolumn.setCellValueFactory(new PropertyValueFactory<>("opDate"));


        try {
            InsertOperationDetailsRows(operationTable,p);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        operationTable.getColumns().add(codeColumn);
        operationTable.getColumns().add(costColumn);
        operationTable.getColumns().add(descriptionColumn);
        operationTable.getColumns().add(operationTypecolumn);
        operationTable.getColumns().add(Datecolumn);
        codeColumn.setMinWidth(80);
        costColumn.setMinWidth(84);
        descriptionColumn.setMinWidth(160);
        operationTypecolumn.setMinWidth(115);
        Datecolumn.setMinWidth(110);



    }
    private void InsertOperationDetailsRows(TableView operationTable,PatientJDBC p) throws SQLException, ClassNotFoundException {

        p.GetOperationDetails(Username,operationTable);


    }

    public  void SetRecentOperationData(PatientJDBC p){
        TableColumn<OperationInfo, String> codeColumn = new TableColumn<>("Code");
        TableColumn<OperationInfo, String> costColumn = new TableColumn<>("Cost");
        TableColumn<OperationInfo, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<OperationInfo, String> operationTypecolumn = new TableColumn<>("Type");
        TableColumn<OperationInfo, String> Datecolumn = new TableColumn<>("Date");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("opCode"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("opCost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("opDesc"));
        operationTypecolumn.setCellValueFactory(new PropertyValueFactory<>("opType"));
        Datecolumn.setCellValueFactory(new PropertyValueFactory<>("opDate"));


        try {
            InsertRecentOperationDetailRow(recentOperation,p);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        recentOperation.getColumns().add(codeColumn);
        recentOperation.getColumns().add(costColumn);
        recentOperation.getColumns().add(descriptionColumn);
        recentOperation.getColumns().add(operationTypecolumn);
        recentOperation.getColumns().add(Datecolumn);
        codeColumn.setMinWidth(80);
        costColumn.setMinWidth(84);
        descriptionColumn.setMinWidth(160);
        operationTypecolumn.setMinWidth(115);
        Datecolumn.setMinWidth(110);



    }
    private void InsertRecentOperationDetailRow(TableView recentOperation,PatientJDBC p) throws SQLException, ClassNotFoundException {

        p.GetRecentOperation(Username,recentOperation);


    }

    public  void SetTreatmentData(PatientJDBC p){
        TableColumn<TreatmentInfo, String> codeColumn = new TableColumn<>("Code");
        TableColumn<TreatmentInfo, String> costColumn = new TableColumn<>("Cost");
        TableColumn<TreatmentInfo, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<TreatmentInfo, String> TypeColumn = new TableColumn<>("Type");
        TableColumn<TreatmentInfo, String> SDateColumn = new TableColumn<>("startDate");
        TableColumn<TreatmentInfo, String> EDateColumn = new TableColumn<>("endDate");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentCode"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentCost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentDesc"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentType"));
        SDateColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentSDate"));
        EDateColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentEDate"));





        try {
            InsertTreatmentDetailsRows(treatmentTable,p);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        treatmentTable.getColumns().add(codeColumn);
        treatmentTable.getColumns().add(costColumn);
        treatmentTable.getColumns().add(descriptionColumn);
        treatmentTable.getColumns().add(TypeColumn);
        treatmentTable.getColumns().add(SDateColumn);
        treatmentTable.getColumns().add(EDateColumn);
        codeColumn.setMinWidth(50);
        costColumn.setMinWidth(50);
        descriptionColumn.setMinWidth(120);
        TypeColumn.setMinWidth(120);
        SDateColumn.setMinWidth(100);
        EDateColumn.setMinWidth(99);




    }
    private void InsertTreatmentDetailsRows(TableView treatmentTable,PatientJDBC p ) throws SQLException, ClassNotFoundException {

        p.GetTreatmentDetails(Username,treatmentTable);


    }

    public  void SetRecentTreatmentData(PatientJDBC p){
        TableColumn<TreatmentInfo, String> codeColumn = new TableColumn<>("Code");
        TableColumn<TreatmentInfo, String> costColumn = new TableColumn<>("Cost");
        TableColumn<TreatmentInfo, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<TreatmentInfo, String> TypeColumn = new TableColumn<>("Type");
        TableColumn<TreatmentInfo, String> SDateColumn = new TableColumn<>("startDate");
        TableColumn<TreatmentInfo, String> EDateColumn = new TableColumn<>("endDate");

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentCode"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentCost"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentDesc"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentType"));
        SDateColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentSDate"));
        EDateColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentEDate"));





        try {
            InsertRecentTreatmentDetailRow(recentTreatment,p);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        recentTreatment.getColumns().add(codeColumn);
        recentTreatment.getColumns().add(costColumn);
        recentTreatment.getColumns().add(descriptionColumn);
        recentTreatment.getColumns().add(TypeColumn);
        recentTreatment.getColumns().add(SDateColumn);
        recentTreatment.getColumns().add(EDateColumn);
        codeColumn.setMinWidth(50);
        costColumn.setMinWidth(50);
        descriptionColumn.setMinWidth(120);
        TypeColumn.setMinWidth(120);
        SDateColumn.setMinWidth(100);
        EDateColumn.setMinWidth(99);




    }
    private void InsertRecentTreatmentDetailRow(TableView recentTreatment,PatientJDBC p ) throws SQLException, ClassNotFoundException {

        p.GetRecentTreatment(Username,recentTreatment);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PatientJDBC p = new PatientJDBC();
        setUsername();
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
        SetOperationData(p);
        SetTreatmentData(p);
        SetRecentLabData(p);
        SetRecentOperationData(p);
        SetRecentTreatmentData(p);



    }


}
