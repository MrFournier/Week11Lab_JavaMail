<%-- 
    Document   : reset
    Created on : Nov 16, 2018, 3:29:29 PM
    Author     : 766375
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        
        <p>Please enter your email address to reset your password</p>
        <form action="reset" method="POST" >
            Email Address: <input type="email" name="emailAddress"><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
