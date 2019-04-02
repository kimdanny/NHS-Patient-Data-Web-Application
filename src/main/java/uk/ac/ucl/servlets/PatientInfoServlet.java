package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patientInfo.html")
public class PatientInfoServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        Model model = ModelFactory.getModel();
        model.getAllPatients();

        String patientID = request.getParameter("para");
        List<String> infoList = model.getPatientInfobyID(patientID);

        request.setAttribute("info", infoList);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/patientInfo.jsp");
        dispatcher.forward(request, response);

    }


}
