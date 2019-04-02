<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<h1>Patient List</h1>
<div class="main">
  <h2>Patients:</h2>
  <ol>
    <%
      List<Patient> patients = (List<Patient>) request.getAttribute("patientNames");
      for (Patient patient : patients)
      {
        String id = patient.getID();
        String href = "patientInfo.html?para=" + id;
    %>
    <li>
      <a href="<%=href%>"><%=patient.getFIRST() + " " + patient.getLAST()%></a>
    </li>
    <% } %>
  </ol>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
