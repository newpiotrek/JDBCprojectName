<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 10/10/2015
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta content='text/html; charset=utf-8' http-equiv='Content-Type'>

  <title>Registration page</title>
</head>

<body>
<h1>Register</h1>

<form action='/' id='registration_form' method='post' name="registration_form">
  <p>First Name: <input name='firstName' type='text'></p>Last Name:
  <input name='lastName' type='text'>

  <p>

  <p>Email: <input name='email' type='text'></p>Confirm Email:
  <input name='confirmEmail' type='text'>

  <p>Password: <input name="password" type="password">

  <p>Confirm Password: <input name="confirmPassword" type="password">

  <p><input name='Submit' type='submit' value='Submit'>

  <p>
</form>
</body>
</html>