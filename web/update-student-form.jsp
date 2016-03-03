<%--
  Created by IntelliJ IDEA.
  User: Santer
  Date: 01.03.2016
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add student</title>

    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>University..</h2>
    </div>
</div>

<div id="container">
    <h3>Add student!</h3>

    <form action="/StudentControllerServlet" method="get">
        <input type="hidden" name="command" value="ADD"/>

        <table>
            <tbody>
            <tr>
                <td><label>First name: </label></td>
                <td><input type="text" name="firstName"/></td>
            </tr>

            <tr>
                <td><label>Last name: </label></td>
                <td><input type="text" name="lastName"/></td>
            </tr>

            <tr>
                <td><label>Email: </label></td>
                <td><input type="text" name="email"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>

            </tbody>
        </table>

    </form>

    <div style="clear: both;"></div>
    <p>
        <a href="/StudentControllerServlet">Back to list...</a>
    </p>
</div>

</body>
</html>
