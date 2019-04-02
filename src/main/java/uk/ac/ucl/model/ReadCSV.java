package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;

public class ReadCSV {
    List<Patient> patientList = new ArrayList<>();
    List<String> headersList = new ArrayList<>();

    public ReadCSV(){}

    protected List<Patient> CSVtoList(String filepath){
        try {
            Scanner scanner = new Scanner(new FileReader(filepath));
            String line;
            Patient patient;

            scanner.nextLine();  // skip fist line

            // building Patient HashMap
            while (scanner.hasNextLine()){
                Patient patientMap = new Patient();
                line = scanner.nextLine();
                String[] results = line.split("\\s*,\\s*", -1);

                patientMap.setID        (results[0]);
                patientMap.setBIRTHDATE (results[1]);
                patientMap.setDEATHDATE (results[2]);
                patientMap.setSSN       (results[3]);
                patientMap.setDRIVERS   (results[4]);
                patientMap.setPASSPORT  (results[5]);
                patientMap.setPREFIX    (results[6]);
                patientMap.setFIRST     (results[7]);
                patientMap.setLAST      (results[8]);
                patientMap.setSUFFIX    (results[9]);
                patientMap.setMAIDEN    (results[10]);
                patientMap.setMARITAL   (results[11]);
                patientMap.setRACE      (results[12]);
                patientMap.setETHNICITY (results[13]);
                patientMap.setGENDER    (results[14]);
                patientMap.setBIRTHPLACE(results[15]);
                patientMap.setADDRESS   (results[16]);
                patientMap.setCITY      (results[17]);
                patientMap.setSTATE     (results[18]);
                patientMap.setZIP       (results[19]);

                patient = patientMap;
                patientList.add(patient);

            }
            scanner.close();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return patientList;
    }



    protected List<String> getHeadersToList(String filepath){
        try {
            Scanner scanner = new Scanner(new FileReader(filepath));
            // headers list
            String line = scanner.nextLine();
            String[] result = line.split("\\s*,\\s*", -1);

            for (int i = 0; i<20; i++){
                headersList.add(result[i]);
            }

            scanner.close();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return headersList;
    }



}
