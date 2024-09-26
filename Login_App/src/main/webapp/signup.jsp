<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
</head>
<body>
    <h2>Sign Up</h2>
    <form action="signup" method="post">
        Email: <input type="email" name="emailid" required /><br/>
        Password: <input type="password" name="password" required /><br/>
        Type of User: 
        <select name="typeofuser" required>
            <option value="admin">Admin</option>
            <option value="customer">Customer</option>
        </select><br/>
        <input type="submit" value="sign Up" />
    </form>
    <a href="login.jsp">Login</a>
</body>
</html>

