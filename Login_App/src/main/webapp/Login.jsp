<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
   <h2>Login</h2>
    <form action="signin" method="post">
        Email: <input type="email" name="emailid" required /><br/>
        Password: <input type="password" name="password" required /><br/>
        Type of User: 
        <select name="typeofuser" required>
            <option value="admin">Admin</option>
            <option value="customer">Customer</option>
        </select><br/>
        <input type="submit" value="Sign In" />
    </form>
    <a href="signup.jsp">Sign Up</a>
</body>
</html>