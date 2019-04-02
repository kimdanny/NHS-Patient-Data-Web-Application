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
    <h2>Statistical Analysis</h2>
    <ul>
        <%
            String averageAge = (String) request.getAttribute("averageAge");
            String mostCommonYearofBirth = (String) request.getAttribute("mostCommonYearofBirth");
            List<Patient> age0to19 = (List<Patient>) request.getAttribute("age0to19");
            List<Patient> age20to65 = (List<Patient>) request.getAttribute("age20to65");
            List<Patient> age66andOver = (List<Patient>) request.getAttribute("age66andOver");
            List<Patient> deadPatientList = (List<Patient>) request.getAttribute("deadPatientList");
            List<Patient> birthdayPatientList = (List<Patient>) request.getAttribute("birthdayPatientList");
        %>
        <h4>Average age of Whole Patient is <%=averageAge%></h4>

        <h4>Most common year of Birth of whole patient is <%=mostCommonYearofBirth%></h4>

        <h3>Age range between 0 and 19 inclusive</h3>
        <% for (Patient patient : age0to19)
            {
                String id = patient.getID();
                String href = "patientInfo.html?para=" +id;
        %>
        <li>
            <a href="<%=href%>"><%=patient.getFIRST() + " " + patient.getLAST()%></a>
        </li>
        <%}%>
        <br>
        <strong>Total number of Patient in this range : <%=age0to19.size()%></strong>

        <h3>Age range between 20 and 65 inclusive</h3>
        <% for (Patient patient : age20to65)
        {
            String id = patient.getID();
            String href = "patientInfo.html?para=" +id;
        %>
        <li>
            <a href="<%=href%>"><%=patient.getFIRST() + " " + patient.getLAST()%></a>
        </li>
        <%}%>
        <br>
        <strong>Total number of Patient in this range : <%=age20to65.size()%></strong>

        <h3>Age range of 66 and over</h3>
        <% for (Patient patient : age66andOver)
        {
            String id = patient.getID();
            String href = "patientInfo.html?para=" +id;
        %>
        <li>
            <a href="<%=href%>"><%=patient.getFIRST() + " " + patient.getLAST()%></a>
        </li>
        <%}%>
        <br>
        <strong>Total number of Patient in this range : <%=age66andOver.size()%></strong>

        <h3>Patient who are dead</h3>
        <% for (Patient patient : deadPatientList)
        {
            String id = patient.getID();
            String href = "patientInfo.html?para=" +id;
        %>
        <li>
            <a href="<%=href%>"><%=patient.getFIRST() + " " + patient.getLAST()%></a>
        </li>
        <%}%>
        <br>
        <strong>Total number of Patient who are dead : <%=deadPatientList.size()%></strong>

        <h3>Birthday Patients</h3>
        <% for (Patient patient : birthdayPatientList)
        {
            String id = patient.getID();
            String href = "patientInfo.html?para=" +id;
        %>
        <li>
            <a href="<%=href%>"><%=patient.getFIRST() + " " + patient.getLAST()%></a>
        </li>
        <%}%>
        <br>
        <strong>How many Birthday patients for today? : <%=birthdayPatientList.size()%></strong>

    </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
