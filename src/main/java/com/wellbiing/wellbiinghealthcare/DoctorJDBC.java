package com.wellbiing.wellbiinghealthcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoctorJDBC {
    void EnterAllergies() {

    }

    void EnterOperation() {
    }

    void EnterTreatments() {
    }

    void EnterMedication() {
    }

    void EnterTest() {
    }

    void EnterVitals() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

        String query = "INSERT INTO TABLE vitals VALUES(?, ?, ?, ?, ?, ?, ?)";




    }


}
