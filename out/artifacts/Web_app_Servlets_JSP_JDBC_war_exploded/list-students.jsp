<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all.Student table</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<h3>It's table of all students </h3>
<br><br>

<div id="wrapper">
    <div id="header">
        <h2>FooBar Univer</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <table>

            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
            </tr>

<c:forEach var="stud" items="${STUDENT_LIST}">
    <tr>
        <td>${stud.firstName}</td>
        <td>${stud.lastName}</td>
        <td>${stud.email}</td>

    </tr>
</c:forEach>


        </table>
    </div>
</div>

<br><br>


</body>
</html>
