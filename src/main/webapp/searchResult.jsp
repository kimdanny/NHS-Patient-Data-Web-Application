<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">

    <h2>Search Result</h2>
    <h3>Patient names</h3>
    <%
        List<Patient> resultsofPatient = (List<Patient>) request.getAttribute("results");
        // if ID is filled in search area
        if (resultsofPatient.size() != 0) {

    %>
    <ol>
        <%
            for (Patient patient : resultsofPatient)
            {
                String id = patient.getID();
                String href = "patientInfo.html?para=" +id;
        %>
        <li>
            <a href="<%=href%>"><%=patient.getFIRST() + " " + patient.getLAST()%></a>
        </li>
        <%}

        } else
        {%>
        <p>Nothing found</p>
        <%}%>
    </ol>



</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>