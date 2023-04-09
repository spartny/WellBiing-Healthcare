package com.wellbiing.wellbiinghealthcare;

import javafx.scene.control.TableView;

import java.sql.*;

public class DoctorJDBC {
    void EnterAllergies(String patientId, String allergyCode, String allergyName, String description, Date date) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String query = "INSERT INTO allergy VALUES(?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, patientId);
        ps.setString(2, allergyCode);
        ps.setString(3, allergyName);
        ps.setString(4, description);
        ps.setDate(5, date);

        ps.execute();

        System.out.println("Success");
    }

    void EnterOperation(String patientId, String opCode, String opCost, String opDescription, String opType, Date opDate) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String query = "INSERT INTO operation VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, patientId);
        ps.setString(2, opCode);
        ps.setString(3, opCost);
        ps.setString(4, opDescription);
        ps.setString(5, opType);
        ps.setDate(6, opDate);

        ps.execute();

        System.out.println("Success");
    }

    void EnterTreatments(String patientId, String trCode, String trCost, String trDescription, String trType, Date sDate, Date eDate) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String query = "INSERT INTO treatments VALUES(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, patientId);
        ps.setString(2, trCode);
        ps.setString(3, trCost);
        ps.setString(4, trDescription);
        ps.setString(5, trType);
        ps.setDate(6, sDate);
        ps.setDate(7, eDate);

        ps.execute();

        System.out.println("Success");
    }

    void EnterMedication(String patientId, String medCode, String medCost, String medDesc, String medType, Date sDate, Date eDate) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String query = "INSERT INTO medication VALUES(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, patientId);
        ps.setString(2, medCode);
        ps.setString(3, medCost);
        ps.setString(4, medDesc);
        ps.setString(5, medType);
        ps.setDate(6, sDate);
        ps.setDate(7, eDate);

        ps.execute();

        System.out.println("Success");
    }

    void EnterTest(String patientId, String testCode, String testCost, String testDesc, String testType, Date testDate) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String query = "INSERT INTO lab VALUES(?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, patientId);
        ps.setString(2, testCode);
        ps.setString(3, testCost);
        ps.setString(4, testDesc);
        ps.setString(5, testType);
        ps.setDate(6, testDate);

        ps.execute();

        System.out.println("Success");
    }

    void EnterVitals(String patientId, String temp, String spO2, String bloodPressure, String heartRate, String breathingRate, Date testDate) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String query = "INSERT INTO vitals VALUES(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, patientId);
        ps.setString(2, temp);
        ps.setString(3, bloodPressure);
        ps.setString(4, heartRate);
        ps.setString(5, breathingRate);
        ps.setDate(6, testDate);
        ps.setString(7, spO2);

        ps.execute();

        System.out.println("Success");


    }

    public void EnterNewPatient(String patientId, String name, Date dob, String gender, String height, String weight, String bloodGroup, String contact,
                                String state, String city, String street) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String piQuery = "INSERT INTO personal_information VALUES(?, ?, ?, ?, ?, ?, ?)";
        String contactQuery = "INSERT INTO contact_info VALUES(?, ?)";
        String addressQuery = "INSERT INTO address VALUES(?, ?, ?, ?)";

        PreparedStatement piPs = con.prepareStatement(piQuery);
        PreparedStatement contactPs = con.prepareStatement(contactQuery);
        PreparedStatement addressPs = con.prepareStatement(addressQuery);

        piPs.setInt(1, Integer.parseInt(patientId));
        piPs.setString(2, name);
        piPs.setDate(3, dob);
        piPs.setString(4, gender);
        piPs.setString(5, height);
        piPs.setString(6, weight);
        piPs.setString(7, bloodGroup);

        contactPs.setString(1, patientId);
        contactPs.setString(2, contact);

        addressPs.setString(1, patientId);
        addressPs.setString(2, street);
        addressPs.setString(3, city);
        addressPs.setString(4, state);

        piPs.execute();
        contactPs.execute();
        addressPs.execute();

    }


    public void GetPatients(TableView curPatientTable) throws ClassNotFoundException, SQLException {
        //System.out.println("TeSTING waow");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String selectAllInfo = "SELECT * FROM personal_information;";

        PreparedStatement selectAllInfoPS = con.prepareStatement(selectAllInfo);

        ResultSet resultSetInfo = selectAllInfoPS.executeQuery();

        String selectAllContact = "SELECT * FROM contact_info WHERE patient_ID = ?;";

        PreparedStatement selectAllContactPS = con.prepareStatement(selectAllContact);

        String selectAllVitals = "SELECT * FROM vitals WHERE patient_ID = ?;";

        PreparedStatement selectAllVitalsPS = con.prepareStatement(selectAllVitals);

        int patientId;
        String patientName;
        String patientContact = "";
        Date patientLastVisit = null;

        while (resultSetInfo.next()) {
            patientId = resultSetInfo.getInt(1);
            patientName = resultSetInfo.getString(2);

            System.out.println(selectAllContactPS);

            selectAllContactPS.setInt(1, patientId);
            ResultSet resultSetContact = selectAllContactPS.executeQuery();

            while (resultSetContact.next()){
                patientContact = resultSetContact.getString(2);
            }

            selectAllVitalsPS.setInt(1, patientId);

            ResultSet resultSetVitals = selectAllVitalsPS.executeQuery();

            while (resultSetVitals.next()){
                patientLastVisit = resultSetVitals.getDate(6);
            }

            curPatientTable.getItems().add(new PatientInfo(patientId, patientName, patientContact, patientLastVisit));
            System.out.println("wow");
        }

    }

    public int GetPatientCount() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String query = "SELECT COUNT(patient_ID) FROM personal_information;";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet countResultSet = ps.executeQuery();

        int patientCount = 0;
        
        while (countResultSet.next()) {
            patientCount = countResultSet.getInt("COUNT(patient_ID)");
        }

        return patientCount;
    }
}
