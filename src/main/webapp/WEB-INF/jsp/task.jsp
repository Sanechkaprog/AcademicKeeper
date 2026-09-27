<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 27.09.2026
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Create task</h2>
    <p>
    <h2>Task</h2>
    </p>
    <form action="task" method="POST">
    <p>
        <label for="description">Description</label><br/>
        <textarea required id="description" name="description" cols="30" rows="10"></textarea>
    </p>
    <p>
        <label for="deadline">Deadline</label>
        <input type="date" required id="deadline" name="deadline">
    </p>
    <p>
        <c:out value="To student with login: ${sessionScope.handle}"/>
    </p>

        <button type="submit">Send</button>
    </form>
</body>
</html>
