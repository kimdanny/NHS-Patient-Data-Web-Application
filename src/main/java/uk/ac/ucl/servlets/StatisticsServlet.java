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
import java.util.List;
import java.io.*;

// The servlet invoked to display a list of patients.
// The url http://localhost:8080/statistics.html is mapped to calling doGet on the servlet object.
// The servlet object is created automatically
@WebServlet("/statistics.html")
public class StatisticsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();

        // Get the data from the model
        // List<Patient> type
        List<Patient> deadPatientsList = model.getDeadPatients();
        List<Patient> bithdayPatientList = model.birthdayPatient();
        List<Patient> age0to19 = model.AgeRange0to19();
        List<Patient> age20to65 = model.AgeRange20to65();
        List<Patient> age66andOver = model.AgeRange66andOver();

        // String type
        String averageAge = model.getAverageAge();
        String mostCommonYearofBirth = model.getMostCommonYearOfBirth();


        // Setting Attribute
        // String type
        request.setAttribute("averageAge", averageAge);
        request.setAttribute("mostCommonYearofBirth", mostCommonYearofBirth);

        // List<Patient> type
        request.setAttribute("age0to19", age0to19);
        request.setAttribute("age20to65", age20to65);
        request.setAttribute("age66andOver", age66andOver);
        request.setAttribute("deadPatientList", deadPatientsList);
        request.setAttribute("birthdayPatientList", bithdayPatientList);


        // Invoke the JSP.
        // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/statistics.jsp");
        dispatch.forward(request, response);
    }

}
