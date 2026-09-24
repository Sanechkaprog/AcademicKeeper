<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="/css/registration-style.css">
</head>

<body>

<form action = "registration" method="POST">
    <p>
        <label for="name">Name</label>
        <input type="text" required id="name" name="name" pattern="[A-zA-Z]+">
    </p>
    <p>
        <label for="surname">Surname</label>
        <input type="text" required id="surname" name="surname" pattern="[A-zA-Z]+">
    </p>
    <p>
        <input type="radio" name="status" value="student" checked /> STUDENT
        <input type="radio" name="status" value="teacher"> TEACHER
    </p>
    <p>
        <label for="login">Login</label>
        <input type="text" required id="login" name="login">
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" required id="password" name="password">
    </p>
    <p>
        <input type="submit" value="Submit">
    </p>
    <c:if test="${errorMessage =='REGISTERED'}">
        <div style="color:red">User has already registered</div>
    </c:if>

</form>
</body>
</html>