<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read record from Address Book</title>
    <style>
        <%@include file="../static/style.css" %>
    </style>
</head>
<body>
<div class="main">
    <div class="userForm">
        <span>
<%@include file="header.html" %>
        </span>
        <%
            String firstName = (String) request.getAttribute("first-name");
            String lastName = (String) request.getAttribute("last-name");
            String Address = (String) request.getAttribute("address");
        %>

        <table>
            <tr>
                <td>First name:</td>
                <td><%=firstName%>
                </td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><%=lastName%>
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><%=Address%>
                </td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
