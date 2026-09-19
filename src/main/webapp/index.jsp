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
        <%
            String error = (String) request.getAttribute("errorMessage");
            if ("EMPTY".equals(error)) {
        %>
        <div style="color:red">Fields can`t be empty</div>
        <%
            }
        %>
        <%
            if ("NOT_REGISTERED".equals(error)) {
        %>
        <div style="color:red">User has not found</div>
        <%
            }
        %>
        <p>
            <p2>Not registered yet? </p2>
            <a href="registration.jsp">Register</a>
        </p>
    </form>
</body>
</html>
