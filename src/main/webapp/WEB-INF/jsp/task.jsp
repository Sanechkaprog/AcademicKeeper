<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 27.09.2026
  Time: 17:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Create task</title>
    <link rel="stylesheet" href="/css/task-page.css">
</head>
<body>
<h2>Create task</h2>

<form action="task" method="POST" class="task-form">
    <p class="field">
        <label for="description">Description</label>
        <textarea required id="description" name="description" cols="30" rows="10"></textarea>
    </p>

    <p class="field">
        <label for="deadline">Deadline</label>
        <input type="date" required id="deadline" name="deadline">
    </p>

    <p class="recipient">
        To student with login: <strong>${sessionScope.handle}</strong>
    </p>

    <button type="submit" class="btn-send">Send</button>
</form>
</body>
</html>