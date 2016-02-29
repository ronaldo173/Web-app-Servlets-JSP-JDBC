<%@ page import="all.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all.Student table</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<%
    List<Student> students = (List<Student>) request.getAttribute("STUDENT_LIST");
%>
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

            <%
                for (Student student : students) {
            %>

            <tr>
                <td><%=student.getFirstName()%>
                </td>
                <td><%=student.getLastName()%>
                </td>
                <td><%=student.getEmail()%>
                </td>
            </tr>
            <% }%>


        </table>
    </div>
</div>

<br><br>


</body>
</html>
