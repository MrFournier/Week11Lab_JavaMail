<%-- 
    Document   : forgot
    Created on : Nov 15, 2018, 10:47:16 AM
    Author     : 766375
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        
        <p>Please enter your email address to receive your password</p>
        <form action="forgot" method="POST" >
            Email Address: <input type="email" name="emailAddress"><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
