<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 20.09.2026
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
    <link rel="stylesheet" href="/css/student-page.css">
</head>
<body>
    <h2>
        Tasks
    </h2>
    <form action="student" method="POST">
        <ul>
            <c:forEach var="item" items="${requestScope.tasks}">
                <li><c:out value="Task №${item.task_id}" /> <button class="btn-success" name="onButton" value="${item.task_id}"> </button></li>
                <c:out value="Creation time: ${item.creation_time}" />
                <br>
                <c:out value="Deadline: ${item.deadline}" />
                <br>
                <c:out value="From: ${item.teacher_login}" />
                <br>
                <c:out value="Description: ${item.description}" />
                <br>
                <c:out value="Status: ${item.statusType}" />
                <br><br>
            </c:forEach>
        </ul>
    </form>

</body>
</html>
