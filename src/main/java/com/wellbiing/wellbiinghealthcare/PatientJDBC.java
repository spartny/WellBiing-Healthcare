package com.wellbiing.wellbiinghealthcare;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PatientJDBC {
    String Username;
    String Age;
    String Height;
    String Weight;
    String Blood_group;
    String Treatment;
    String Checkup;
    String allergies="";
    String medication ="";
    int id;
    String Id;
    String gender;
    String testDate;
    ObservableList<LabData> labData;

    public void GetInfo(String username){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.19.19.197:3306/wellbiinghealthcare", "whc", "pass123");

            // query for getId
            String query3 ="Select ID from authentication where username= ?";
            PreparedStatement ps3=con.prepareStatement(query3);
            ps3.setString(1, username);
            ResultSet rs3=ps3.executeQuery();
            if (rs3.next()) {
                id = rs3.getInt(1);

            }

            // query for DOB
            String query="Select * from personal_information where patient_ID= ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            Date D_O_B = null;
            Double height = 0.0;
            Double weight =0.0;

            if (rs.next()) {
                D_O_B = rs.getDate(3);

                gender = rs.getString(4);
                height = rs.getDouble(5);
                weight = rs.getDouble(6);
                Blood_group = rs.getString(7);
                Username= rs.getString(2);

            }
            int Birth_year = D_O_B.getYear()+1900;

            int Current_year = Calendar.getInstance().get(Calendar.YEAR);


            int age = (Current_year)-(Birth_year);
            Age = Integer.toString(age);
            Height = Double.toString(height)+" "+"cm";
            Weight =Double.toString(weight)+" "+"kg";
            Id = Integer.toString(id);

            // query for Treatment_type
            String query1="Select Treatment_type from treatments where  patient_ID= ?";
            PreparedStatement ps1=con.prepareStatement(query1);
            ps1.setInt(1, id);
            ResultSet rs1=ps1.executeQuery();
            if(rs1.next()){
                Treatment = rs1.getString(1);
            }

            // query for last checkup
            String query2="Select Test_date from vitals where  patient_ID= ?";
            PreparedStatement ps2=con.prepareStatement(query2);
            ps2.setInt(1, id);
            ResultSet rs2=ps2.executeQuery();
            if(rs2.next()){
                testDate = rs2.getString(1);
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                Date date = dt.parse(testDate);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd-mm-yyyy");
                 Checkup = dt1.format(date);

            }

            // query for Allergies
            String query4 = "Select Allergy_Name from allergy where patient_ID= ? ";
            PreparedStatement ps4 = con.prepareStatement(query4);
            ps4.setInt(1,id);
            ResultSet rs4 =ps4.executeQuery();
            for(int i =0; i<3;i++){
                if(rs4.next()){
                   allergies = allergies + rs4.getString(1)+ "\n";

                }
                else{
                    break;
                }
            }

            // query for medicine
            String query5 = "Select Medication_type from medication where patient_ID= ? ";
            PreparedStatement ps5 = con.prepareStatement(query5);
            ps5.setInt(1,id);
            ResultSet rs5 =ps5.executeQuery();
            for(int i =0; i<=3;i++){
                if(rs5.next()){
                    medication = medication + rs5.getString(1)+"\n";
                }
                else{
                    break;
                }
            }
            labData = FXCollections.observableArrayList();
            String query6 = "Select * from lab where patient_ID= ?";
            PreparedStatement ps6 = con.prepareStatement(query6);
            ps6.setInt(1,id);
            ResultSet rs6 =ps6.executeQuery();
            while(rs6.next()){
                labData.add(new LabData(
                        rs6.getString(2),
                        rs6.getString(3),
                        rs6.getString(4),
                        rs6.getString(5),
                        rs6.getString(6)
                ));


            }
            System.out.println(labData.get(1));



            con.close();




        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
