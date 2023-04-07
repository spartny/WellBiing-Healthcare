package com.wellbiing.wellbiinghealthcare;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
public class PatientJDBC {
    String Username;
    String Age;
    String Height;
    String Weight;
    String Blood_group;
    String Treatment;
    String Checkup;
    String allergies[];
    String medication[];
    int id;

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

            // query for Treatment_type
            String query1="Select Treatment_type from treatments where  patient_ID= ?";
            PreparedStatement ps1=con.prepareStatement(query1);
            ps1.setInt(1, id);
            ResultSet rs1=ps1.executeQuery();
            if(rs1.next()){
                Treatment = rs1.getString(1);
            }

            // query for LabTest_type
            String query2="Select LabTest_type from lab where  patient_ID= ?";
            PreparedStatement ps2=con.prepareStatement(query2);
            ps2.setInt(1, id);
            ResultSet rs2=ps2.executeQuery();
            if(rs2.next()){
                Checkup = rs2.getString(1);
            }



            con.close();




        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
