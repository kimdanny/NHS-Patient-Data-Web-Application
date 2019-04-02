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

// The servlet invoked to perform a search.
@WebServlet("/runSearch.html")
public class SearchServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // list of matched Patient
        List<Patient> results = new ArrayList<>();
        Model model = ModelFactory.getModel();

        results.addAll(model.searchForID(request.getParameter("searchID")));
        results.addAll(model.searchForLast(request.getParameter("searchName")));

        request.setAttribute("results", results);


        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
        dispatch.forward(request, response);
    }
}
