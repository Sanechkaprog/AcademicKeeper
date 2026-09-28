<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 27.09.2026
  Time: 17:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Teacher</title>
    <link rel="stylesheet" href="/css/teacher-page.css">
</head>
<body>
<h2>Students</h2>
<form action="taskred" method="POST">
    <ul class="student-list">
        <c:forEach var="student" items="${requestScope.students}">
            <li class="student-card">
                <div class="student-header">
                    <span class="student-role">${student.person_sysrole}</span>
                    <button class="btn-create" name="onButton" value="${student.login}">
                        Create task
                    </button>
                </div>
                <div class="student-body">
                    <p><span class="label">Login:</span> ${student.login}</p>
                    <p><span class="label">Name:</span> ${student.name}</p>
                    <p><span class="label">Surname:</span> ${student.surname}</p>
                </div>
            </li>
        </c:forEach>
    </ul>
</form>
</body>
</html>