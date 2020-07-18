<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update record in Address Book</title>
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

        <form action="/records/update" method="post">

            <%
                String firstName = (String) request.getAttribute("first-name");
                String lastName = (String) request.getAttribute("last-name");
            %>

            <table>
                <tr>
                    <td>
                        <label for="firstName">FirstName: </label>
                    </td>
                    <td>
                        <input type="text" id="firstName" name="first-name" value="<%=firstName%>" disabled>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="lastName">LastName: </label>
                    </td>
                    <td>
                        <input type="text" id="lastName" name="last-name" value="<%=lastName%>" disabled>
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
                        <input type="submit" value="Update">
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


