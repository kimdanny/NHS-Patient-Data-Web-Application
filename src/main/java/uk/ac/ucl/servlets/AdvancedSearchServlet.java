package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/runAdvancedSearch.html")
public class AdvancedSearchServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // list of matched Patient
        List<Patient> results = new ArrayList<>();
        Model model = ModelFactory.getModel();

        // PatientList filtered by Address Information
        List<Patient> patientListbyCity = model.searchForCity(request.getParameter("searchCity"));
        List<Patient> patientListbyZip = model.searchForZip(request.getParameter("searchZip"));

        // PatientList filtered by Selection Information
        List<Patient> patientListbyGender = model.searchForGender(request.getParameter("Gender"));
        List<Patient> patientListbyMarital = model.searchForMarital(request.getParameter("Marital"));
        List<Patient> patientListbyRace = model.searchForRace(request.getParameter("Race"));

        // Common Patients of Selected field
        List<Patient> commonPatientbyAddress = model.findCommonPatient(patientListbyCity, patientListbyZip);
        List<Patient> commonPatientbySelectionField = model.findCommonPatient(patientListbyGender, patientListbyMarital, patientListbyRace);

        //List<Patient> finalCommonPatient = model.findCommonPatient(commonPatientbyAddress, commonPatientbySelectionField);

        // Append to result List that is to be sent to jsp file
        results.addAll(commonPatientbyAddress);
        results.addAll(commonPatientbySelectionField);
        //results.addAll(finalCommonPatient);

        // Append to results
        //results.addAll(patientListbyCity);
        //results.addAll(patientListbyZip);



        request.setAttribute("results", results);


        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/advancedSearchResult.jsp");
        dispatch.forward(request, response);
    }

}
