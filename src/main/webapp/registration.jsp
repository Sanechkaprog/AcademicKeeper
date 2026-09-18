<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>

<body>
<form action = "registration" method="POST">
    Name: <input name="username">
    <br><br>
    Surname: <input name="surname">
    <br><br>
    Status: <input type="radio" name="status" value="student" checked /> STUDENT
    <input type="radio" name="status" value="teacher"> TEACHER
    <br><br>
    Login: <input name="login">
    <br><br>
    Password <input name="password">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>