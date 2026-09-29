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
    <link rel="stylesheet" href="/css/student-pagev2.css">
</head>
<body>
    <h2>
        Tasks
    </h2>
    <form action="student" method="POST">
        <c:forEach var="item" items="${requestScope.tasks}">
            <li class="task-card">
                <div class="task-header">
                    <span class="task-title">Task №${item.task_id}</span>
                    <button class="btn-success" name="onButton" value="${item.task_id}"></button>
                </div>
                <div class="task-body">
                    <p><span class="label">Creation time:</span> ${item.creation_time}</p>
                    <p><span class="label">Deadline:</span> ${item.deadline}</p>
                    <p><span class="label">From:</span> ${item.teacher_login}</p>
                    <p><span class="label">Description:</span> ${item.description}</p>
                    <p><span class="label">Status:</span> ${item.statusType}</p>
                </div>
            </li>
        </c:forEach>
    </form>
</body>
</html>
