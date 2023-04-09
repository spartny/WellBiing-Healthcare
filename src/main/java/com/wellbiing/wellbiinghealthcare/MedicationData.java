package com.wellbiing.wellbiinghealthcare;

import javafx.beans.property.SimpleStringProperty;

public class MedicationData {
    String Medication_code;
    String Medication_cost;
    String Medication_description;
    String Medication_type;
    String Medication_Sdate;
    String Medication_Edate;
    MedicationData(String Medication_code, String Medication_cost, String Medication_description, String Medication_type, String Medication_Sdate,String Medication_Edate ){
        this.Medication_code=Medication_code;
        this.Medication_cost =Medication_cost;
        this.Medication_description=Medication_description;

        this.Medication_type =Medication_type;
        this.Medication_Sdate = Medication_Sdate;
        this.Medication_Edate = Medication_Edate;

    }
    public String getMedication_code(){
        return Medication_code;
    }
    public  void SetMedication_code(String Medication_code){
        this.Medication_code=Medication_code;

    }
    public String getMedication_cost(){
        return Medication_cost;
    }
    public  void SetLMedication_cost(String Medication_cost){
        this.Medication_cost=Medication_cost;

    }
    public String getMedication_description(){
        return Medication_description;
    }
    public  void SetMedication_description(String Medication_description){
        this.Medication_description=Medication_description;
    }
    public String getMedication_type(){
        return Medication_type;
    }
    public  void SetMedication_type(String Medication_type){
        this.Medication_type=Medication_type;
    }
    public String getMedication_Sdate(){
        return Medication_Sdate;
    }
    public  void SetMedication_Sdate(String Medication_Sdate){
        this.Medication_Sdate=Medication_Sdate;
    }
    public String getMedication_Edate(){
        return Medication_Edate;
    }
    public  void SetMedication_Edate(String Medication_Edate){
        this.Medication_Edate=Medication_Edate;
    }
}
