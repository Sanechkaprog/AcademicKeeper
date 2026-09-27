<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 27.09.2026
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Teacher</title>
</head>
<body>
    <h2>Students</h2>
    <form action="taskred" method="POST">
        <ul>
            <c:forEach var="student" items="${requestScope.students}">
                <li><c:out value="${student.person_sysrole}" /><button name="onButton" value="${student.login}">Create task</button></li>
                <c:out value="Login: ${student.login}" />
                <br>
                <c:out value="Name: ${student.name}" />
                <br>
                <c:out value="Surname ${student.surname}" />
                <br><br>
            </c:forEach>
        </ul>
    </form>


</body>
</html>
