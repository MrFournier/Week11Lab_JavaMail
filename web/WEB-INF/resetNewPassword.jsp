<%-- 
    Document   : resetNewPassword
    Created on : Nov 16, 2018, 3:38:49 PM
    Author     : 766375
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Password</title>
    </head>
    <body>
        <h1>Enter a new password</h1>
        <form action="reset?newPass" method="POST">
            <input type="hidden" name="resetUUID" value="" >
            <input type="text" name="newPassword" >
            <input type="submit" value="Submit" >
        </form>
    </body>
</html>
