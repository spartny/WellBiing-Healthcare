package com.wellbiing.wellbiinghealthcare;

import javafx.beans.property.SimpleStringProperty;

public class LabData {
    private final SimpleStringProperty LabTest_code;
    private final SimpleStringProperty LabTest_cost;
    private final SimpleStringProperty LabTest_description;
    private final SimpleStringProperty LabTest_type;
    private final SimpleStringProperty LabTest_date;
    LabData(String LabTest_code, String LabTest_cost, String LabTest_description, String LabTest_type, String LabTest_date ){
        this.LabTest_code= new  SimpleStringProperty(LabTest_code);
        this.LabTest_cost = new SimpleStringProperty(LabTest_cost);
        this.LabTest_description= new SimpleStringProperty(LabTest_description);
        this.LabTest_type = new SimpleStringProperty(LabTest_type);
        this.LabTest_date = new SimpleStringProperty(LabTest_date);

    }
    public String getLabTest_code(){
        return LabTest_code.get();
    }
    public  void SetLabTest_code(String LabTest_code){
        this.LabTest_code.set(LabTest_code);
        System.out.println(LabTest_code);
    }
    public String getLabTest_cost(){
        return LabTest_cost.get();
    }
    public  void SetLabTest_cost(String LabTest_cost){
        this.LabTest_cost.set(LabTest_cost);

    }
    public String LabTest_description(){
        return LabTest_description.get();
    }
    public  void SetLabTest_description(String LabTest_description){
        this.LabTest_description.set(LabTest_description);
    }
    public String getLabTest_type(){
        return LabTest_type.get();
    }
    public  void SetLabTest_type(String LabTest_type){
        this.LabTest_type.set(LabTest_type);
    }
    public String getLabTest_date(){
        return LabTest_date.get();
    }
    public  void SetLabTest_date(String LabTest_date){
        this.LabTest_date.set(LabTest_date);
    }

}
