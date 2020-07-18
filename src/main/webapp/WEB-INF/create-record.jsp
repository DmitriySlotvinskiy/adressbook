<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create record form</title>
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
        <form action="/records/create" method="post">

            <%
                String error = (String) request.getAttribute("error");
                if (error != null) {
            %><p><%= error %>
        </p><%
            }
        %>


            <table>
                <tr>
                    <td>
                        <label for="firstName">FirstName: </label>
                    </td>
                    <td>
                        <input type="text" id="firstName" name="firstName">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="lastName">LastName: </label>
                    </td>
                    <td>
                        <input type="text" id="lastName" name="lastName">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="address">Address: </label>
                    </td>
                    <td>
                        <input type="text" id="address" name="address">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Create">
                    </td>
                    <td>
                        <input type="reset" value="Clear">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>
</div>


</body>

</html>

