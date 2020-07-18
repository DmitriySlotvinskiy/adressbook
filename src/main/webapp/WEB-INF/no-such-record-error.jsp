<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Record not found</title>
</head>
<body>

<%
    String firstName = (String) request.getAttribute("first-name");
    String lastName = (String) request.getAttribute("last-name");
%>
<h2>Person with name '<%=firstName%>  <%=lastName%>' not found in Address Book!</h2>
</body>
</html>
