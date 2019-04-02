package uk.ac.ucl.model;

import java.util.HashMap;
public class Patient {

    private HashMap<String, String> infomap;

    public Patient() {
        this.infomap = new HashMap<>();
    }

    public void setID(String id){
        infomap.put("ID",id );
    }
    public String getID(){
        return infomap.get("ID");
    }

    public void setBIRTHDATE(String birthdate){
        infomap.put("BIRTHDATE",birthdate );
    }
    public String getBIRTHDATE(){
        return infomap.get("BIRTHDATE");
    }

    public void setDEATHDATE(String deathdate){
        infomap.put("DEATHDATE", deathdate);
    }
    public String getDEATHDATE(){
        return infomap.get("DEATHDATE");
    }

    public void setSSN(String ssn){
        infomap.put("SSN", ssn);
    }
    public String getSSN(){
        return infomap.get("SSN");
    }

    public void setDRIVERS(String drivers){
        infomap.put("DRIVERS", drivers);
    }
    public String getDRIVERS(){
        return infomap.get("DRIVERS");
    }

    public void setPASSPORT(String passport){
        infomap.put("PASSPORT", passport);
    }
    public String getPASSPORT(){
        return infomap.get("PASSPORT");
    }

    public void setPREFIX(String prefix){
        infomap.put("PREFIX", prefix);
    }
    public String getPREFIX(){
        return infomap.get("PREFIX");
    }

    public void setFIRST(String first){
        infomap.put("FIRST", first);
    }
    public String getFIRST(){
        return infomap.get("FIRST");
    }

    public void setLAST(String last){
        infomap.put("LAST", last);
    }
    public String getLAST(){
        return infomap.get("LAST");
    }

    public void setSUFFIX(String suffix){
        infomap.put("SUFFIX", suffix);
    }
    public String getSUFFIX(){
        return infomap.get("SUFFIX");
    }

    public void setMAIDEN(String maiden){
        infomap.put("MAIDEN", maiden);
    }
    public String getMAIDEN(){
        return infomap.get("MAIDEN");
    }

    public void setMARITAL(String marital){
        infomap.put("MARITAL", marital);
    }
    public String getMARITAL(){
        return infomap.get("MARITAL");
    }

    public void setRACE(String race){
        infomap.put("RACE", race);
    }
    public String getRACE(){
        return infomap.get("RACE");
    }

    public void setETHNICITY(String ethnicity){
        infomap.put("ETHNICITY", ethnicity);
    }
    public String getETHNICITY(){
        return infomap.get("ETHNICITY");
    }

    public void setGENDER(String gender){
        infomap.put("GENDER", gender);
    }
    public String getGENDER(){
        return infomap.get("GENDER");
    }

    public void setBIRTHPLACE(String birthplace){
        infomap.put("BIRTHPLACE", birthplace);
    }
    public String getBIRTHPLACE(){
        return infomap.get("BIRTHPLACE");
    }

    public void setADDRESS(String address){
        infomap.put("ADDRESS", address);
    }
    public String getADDRESS(){
        return infomap.get("ADDRESS");
    }

    public void setCITY(String city){
        infomap.put("CITY", city);
    }
    public String getCITY(){
        return infomap.get("CITY");
    }

    public void setSTATE(String state){
        infomap.put("STATE", state);
    }
    public String getSTATE(){
        return infomap.get("STATE");
    }

    public void setZIP(String zip){
        infomap.put("ZIP", zip);
    }
    public String getZIP(){
        return infomap.get("ZIP");
    }


    public String getValueOf(String key) {
        return infomap.get(key);
    }

}
