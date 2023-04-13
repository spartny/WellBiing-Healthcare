package com.wellbiing.wellbiinghealthcare;

public class OperationData {
    String opCode;
    String opCost;
    String opDesc;
    String opType;
    String opDate;
    OperationData(String opCode, String opCost, String opDesc, String opType, String opDate ){
        this.opCode=opCode;
        this.opCost =opCost;
        this.opDesc=opDesc;

        this.opType =opType;
        this.opDate = opDate;


    }
    public String getopCode(){
        return opCode;
    }
    public  void SetopCode(String opCode){
        this.opCode=opCode;

    }
    public String getopCost(){
        return opCost;
    }
    public  void SetopCost(String opCost){
        this.opCost=opCost;

    }
    public String getopDesc(){
        return opDesc;
    }
    public  void SetopDesc(String opDesc){
        this.opDesc=opDesc;
    }
    public String getopType(){
        return opType;
    }
    public  void SetopType(String opType){
        this.opType=opType;
    }
    public String getopDate(){
        return opDate;
    }
    public  void SetopDate(String opDate){
        this.opDate=opDate;
    }

}
