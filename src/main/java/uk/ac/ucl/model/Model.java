package uk.ac.ucl.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    private ReadCSV readCSV = new ReadCSV();
    private List<Patient> patientList;
    private List<String> headerList;

    public Model(String filepath) {
        patientList = this.readFile(filepath);
        headerList = this.readHeaders(filepath);
    }

    public List<Patient> readFile(String filepath) {
        return readCSV.CSVtoList(filepath);
    }


    public List<String> readHeaders(String filepath) {
        return readCSV.getHeadersToList(filepath);
    }

    public List<Patient> getAllPatients() {
        return patientList;
    }


    // This can return multiple patient
    public List<Patient> searchForLast(String Last) {
        List<Patient> result = new ArrayList<>();

        // traversing
        for (Patient patient : patientList) {
            if (patient.getLAST().equals(Last)) {
                result.add(patient);
            }
        }
        return result;
    }


    // This return only one patient
    public List<Patient> searchForID(String ID) {
        List<Patient> result = new ArrayList<>();

        // traversing
        for (Patient patient : patientList) {
            if (patient.getID().equals(ID)) {
                result.add(patient);
            }
        }
        return result;
    }

    // This method is for advanced search
    public List<Patient> searchForCity(String city) {
        List<Patient> result = new ArrayList<>();

        // traversing
        for (Patient patient : patientList) {
            if (patient.getCITY().equals(city)) {
                result.add(patient);
            }
        }
        return result;
    }

    // This method is for advanced search
    public List<Patient> searchForGender(String gender) {
        List<Patient> result = new ArrayList<>();

        // traversing
        for (Patient patient : patientList) {
            if (patient.getGENDER().equals(gender)) {
                result.add(patient);
            }
        }
        return result;
    }

    // This method is for advanced search
    public List<Patient> searchForZip(String zip) {
        List<Patient> result = new ArrayList<>();

        // traversing
        for (Patient patient : patientList) {
            if (patient.getZIP().equals(zip)) {
                result.add(patient);
            }
        }
        return result;
    }

    // This method is for advanced search
    public List<Patient> searchForMarital(String marital) {
        List<Patient> result = new ArrayList<>();

        // traversing
        for (Patient patient : patientList) {
            if (patient.getMARITAL().equals(marital)) {
                result.add(patient);
            }
        }
        return result;
    }

    // This method is for advanced search
    public List<Patient> searchForRace(String race) {
        List<Patient> result = new ArrayList<>();

        // traversing
        for (Patient patient : patientList) {
            if (patient.getRACE().equals(race)) {
                result.add(patient);
            }
        }
        return result;
    }

    // Check every patient and see if they have common patient
    public List<Patient> findCommonPatient(List<Patient> list1, List<Patient> list2) {

        List<Patient> resultList = new ArrayList<>();

        for (Patient patientInList1 : list1) {
            if (list2.contains(patientInList1)) {
                // it is common patient!
                resultList.add(patientInList1);
            }
        }

        return resultList;
    }

    // Overloading the method
    public List<Patient> findCommonPatient(List<Patient> list1, List<Patient> list2, List<Patient> list3) {

        List<Patient> resultList = new ArrayList<>();

        // Find common patient in list1 and list2
        List<Patient> twoListDealtList = findCommonPatient(list1, list2);

        for (Patient patientInDealtList : twoListDealtList) {
            if (list3.contains(patientInDealtList)) {
                resultList.add(patientInDealtList);
            }

        }

        return resultList;
    }


    // getPatient info by ID
    // Since ID is patients' distinct value ID is good parameter for this method
    public List<String> getPatientInfobyID(String ID) {
        List<String> result = new ArrayList<>();

        // traversing
        for (Patient patient : patientList) {
            if (patient.getID().equals(ID)) {
                result.add(headerList.get(0) + " : " + patient.getID());
                result.add(headerList.get(1) + " : " + patient.getBIRTHDATE());
                result.add(headerList.get(2) + " : " + patient.getDEATHDATE());
                result.add(headerList.get(3) + " : " + patient.getSSN());
                result.add(headerList.get(4) + " : " + patient.getDRIVERS());
                result.add(headerList.get(5) + " : " + patient.getPASSPORT());
                result.add(headerList.get(6) + " : " + patient.getPREFIX());
                result.add(headerList.get(7) + " : " + patient.getFIRST());
                result.add(headerList.get(8) + " : " + patient.getLAST());
                result.add(headerList.get(9) + " : " + patient.getSUFFIX());
                result.add(headerList.get(10) + " : " + patient.getMAIDEN());
                result.add(headerList.get(11) + " : " + patient.getMARITAL());
                result.add(headerList.get(12) + " : " + patient.getRACE());
                result.add(headerList.get(13) + " : " + patient.getETHNICITY());
                result.add(headerList.get(14) + " : " + patient.getGENDER());
                result.add(headerList.get(15) + " : " + patient.getBIRTHPLACE());
                result.add(headerList.get(16) + " : " + patient.getADDRESS());
                result.add(headerList.get(17) + " : " + patient.getCITY());
                result.add(headerList.get(18) + " : " + patient.getSTATE());
                result.add(headerList.get(19) + " : " + patient.getZIP());

            }
        }

        return result;
    }

    /*******************
     *   Statistics    *
     *******************/

    public List<Patient> getDeadPatients() {
        List<Patient> deadList = new ArrayList<>();
        for (Patient patient : patientList) {
            if (patient.getDEATHDATE().contains("-")) {
                deadList.add(patient);
            }
        }
        return deadList;
    }

    public String getAverageAge() {
        List<Integer> ageList = new ArrayList<>();
        int sum = 0;
        int averageAge;

        //Getting current yy mm dd in int
        String[] current = getCurrentDate().split("-");
        int currentYear = Integer.parseInt(current[0]);
        int currentMonth = Integer.parseInt(current[1]);
        int currentDate = Integer.parseInt(current[2]);

        LocalDate currentYearMonthDate = LocalDate.of(currentYear, currentMonth, currentDate);

        // Getting patient's yy mm dd in int
        for (Patient patient : patientList) {
            String getBirthDate = patient.getBIRTHDATE();
            String[] birthDate = getBirthDate.split("-");
            int year = Integer.parseInt(birthDate[0]);
            int month = Integer.parseInt(birthDate[1]);
            int day = Integer.parseInt(birthDate[2]);

            LocalDate birthdate = LocalDate.of(year, month, day);

            int age = getAge(birthdate, currentYearMonthDate);

            ageList.add(age);
        }

        // calculating average age
        for (int age : ageList) {
            sum = sum + age;
        }
        averageAge = sum / ageList.size();

        return "" + averageAge;
    }

    // helper method for getAverageAge
    // return time difference in year as an int type
    private int getAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    // helper method for getAverageAge
    // return current yyyy-mm--dd in String
    private String getCurrentDate() {
        return LocalDate.now().toString();
    }


    public List<Patient> birthdayPatient() {

        List<Patient> birthdayPatientList = new ArrayList<>();

        //Getting current yy mm dd in int
        String[] current = getCurrentDate().split("-");
        int currentMonth = Integer.parseInt(current[1]);
        int currentDate = Integer.parseInt(current[2]);

        // Getting patient's yy mm dd in int
        for (Patient patient : patientList) {
            String getBirthDate = patient.getBIRTHDATE();
            String[] birthDate = getBirthDate.split("-");
            int month = Integer.parseInt(birthDate[1]);
            int date = Integer.parseInt(birthDate[2]);

            // check if today is patient's birthday
            // Happy birthday!
            if (currentMonth == month && currentDate == date) {
                birthdayPatientList.add(patient);
            }
        }
        return birthdayPatientList;
    }


    public String getMostCommonYearOfBirth() {
        List<String> yearsList = new ArrayList<>();

        for (Patient patient : patientList) {
            String birthDate = patient.getBIRTHDATE();
            String[] result = birthDate.split("-");
            yearsList.add(result[0]);
        }
        return mostCommonOne(yearsList);
    }

    // helper class for getMostCommonYearOfBirth()
    // Finds most common element in the list and returns the one in String
    private String mostCommonOne(List<String> inputList) {

        Map<String, Integer> map = new HashMap<>();
        String resultKey = null;
        int tempNumber = 0;

        for (int x = 0; x < inputList.size(); x++) {

            Integer howMany = map.get(inputList.get(x));
            if (howMany == null) {
                map.put(inputList.get(x), 1);
            } else {
                map.put(inputList.get(x), howMany + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > tempNumber) {
                resultKey = entry.getKey();
                tempNumber = entry.getValue();
            }
        }
        return resultKey;
    }



    public List<Patient> AgeRange0to19() {

        List<Patient> result = new ArrayList<>();

        //Getting current yy mm dd in int
        String[] current = getCurrentDate().split("-");
        final int currentYear = Integer.parseInt(current[0]);
        final int currentMonth = Integer.parseInt(current[1]);
        final int currentDate = Integer.parseInt(current[2]);

        LocalDate currentYearMonthDate = LocalDate.of(currentYear, currentMonth, currentDate);

        for (Patient patient : patientList) {
            // Getting patient's age
            String getBirthDate = patient.getBIRTHDATE();
            String[] birthDate = getBirthDate.split("-");
            int year = Integer.parseInt(birthDate[0]);
            int month = Integer.parseInt(birthDate[1]);
            int day = Integer.parseInt(birthDate[2]);

            LocalDate birthdate = LocalDate.of(year, month, day);

            int patientAge = getAge(birthdate, currentYearMonthDate);

            // check age range
            if (0 <= patientAge && patientAge <= 19) {
                result.add(patient);
            }
        }
        return result;

    }

        public List<Patient> AgeRange20to65 () {
            List<Patient> result = new ArrayList<>();

            //Getting current yy mm dd in int
            String[] current = getCurrentDate().split("-");
            final int currentYear = Integer.parseInt(current[0]);
            final int currentMonth = Integer.parseInt(current[1]);
            final int currentDate = Integer.parseInt(current[2]);

            LocalDate currentYearMonthDate = LocalDate.of(currentYear, currentMonth, currentDate);

            for (Patient patient : patientList) {
                // Getting patient's age
                String getBirthDate = patient.getBIRTHDATE();
                String[] birthDate = getBirthDate.split("-");
                int year = Integer.parseInt(birthDate[0]);
                int month = Integer.parseInt(birthDate[1]);
                int day = Integer.parseInt(birthDate[2]);

                LocalDate birthdate = LocalDate.of(year, month, day);

                int patientAge = getAge(birthdate, currentYearMonthDate);

                // check age range
                if (20 <= patientAge && patientAge <= 65) {
                    result.add(patient);
                }
            }
            return result;

        }

        public List<Patient> AgeRange66andOver () {

            List<Patient> result = new ArrayList<>();

            //Getting current yy mm dd in int
            String[] current = getCurrentDate().split("-");
            final int currentYear = Integer.parseInt(current[0]);
            final int currentMonth = Integer.parseInt(current[1]);
            final int currentDate = Integer.parseInt(current[2]);

            LocalDate currentYearMonthDate = LocalDate.of(currentYear, currentMonth, currentDate);

            for (Patient patient : patientList) {
                // Getting patient's age
                String getBirthDate = patient.getBIRTHDATE();
                String[] birthDate = getBirthDate.split("-");
                int year = Integer.parseInt(birthDate[0]);
                int month = Integer.parseInt(birthDate[1]);
                int day = Integer.parseInt(birthDate[2]);

                LocalDate birthdate = LocalDate.of(year, month, day);

                int patientAge = getAge(birthdate, currentYearMonthDate);

                // check age range
                if (66 <= patientAge) {
                    result.add(patient);
                }
            }
            return result;

        }



}

