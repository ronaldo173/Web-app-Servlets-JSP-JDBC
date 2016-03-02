<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student table</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<h3>It's table of all students </h3>
<br><br>

<div id="wrapper">
    <div id="header">
        <h2>University...</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <input type="button" value="Add student" onclick="window.location.href='add-student-form.jsp'; return false;"
               class="add-student-button">
        <table>

            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="stud" items="${STUDENT_LIST}">
                <c:url var="tempLink" value="StudentControllerServlet">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="studentId" value="${stud.id}"/>
                </c:url>
                <tr>
                    <td>${stud.firstName}</td>
                    <td>${stud.lastName}</td>
                    <td>${stud.email}</td>
                    <td><a href="${tempLink}">Update</a></td>

                </tr>
            </c:forEach>


        </table>
    </div>
</div>

<br><br>


</body>
</html>
