<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
    <link rel="stylesheet" href="/css/index-styler.css">
</head>
<body>
<form action="index" method="POST">
    <p>
        <label for="login">Login</label>
        <input type="text" required id="login" name="login">
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" required id="password" name="password">
    </p>
    <p>
        <input type="radio" name="status" value="student" checked /> STUDENT
        <input type="radio" name="status" value="teacher"> TEACHER
    </p>
    <p>
        <input type="submit" value="Submit">
    </p>
    <c:if test="${errorMessage =='NOT_REGISTERED'}">
        <div style="color:red">User not found</div>
    </c:if>

    <c:if test="${errorMessage == 'INCORRECT_PASSWORD'}">
        <div style="color:red">Your password is invalid</div>
    </c:if>
    <p>
        <p2>Not registered yet? </p2>
        <a href="registration.jsp">Register</a>
    </p>
</form>
</body>
</html>
