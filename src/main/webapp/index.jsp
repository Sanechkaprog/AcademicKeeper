<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Main page</title>
    </head>
<body>
    <form action="index" method="POST">
        <p>
            Login: <input name="login">
        </p>
        <p>
            Password: <input name="password">
        </p>
        <p>
            Status: <input type="radio" name="status" value="student" checked /> STUDENT
            <input type="radio" name="status" value="teacher"> TEACHER
        </p>
        <p>
             <input type="submit" value="Submit">
        </p>
        <c:if test="${errorMessage =='NOT_REGISTERED'}">
            <div style="color:red">User not found</div>
        </c:if>

        <c:if test="${errorMessage == 'EMPTY'}">
            <div style="color:red">Fields can`t be empty</div>
        </c:if>
        <p>
            <p2>Not registered yet? </p2>
            <a href="registration.jsp">Register</a>
        </p>
    </form>
</body>
</html>
