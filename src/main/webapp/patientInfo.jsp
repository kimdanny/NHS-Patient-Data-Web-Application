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
    <h2>Patient:</h2>

    <ul>
        <%
            List<String> infoList = (List<String>) request.getAttribute("info");
            for (String info : infoList)
            {
              %>

        <li><%=info%></li>

            <%}%>

    </ul>

</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
