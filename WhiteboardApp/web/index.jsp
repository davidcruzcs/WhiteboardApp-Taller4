<%-- 
    Document   : login
    Created on : 18-sep-2016, 22:14:36
    Author     : juandavidcruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
    <center>
        <form>
            <h1>Please Enter your Username</h1>
            <input id="userField" type="text" placeholder="username...">
            <button onclick="login(document.getElementById('userField').value);">Enter App!</button>
        </form>
        </center>
     <script type="text/javascript" src="users.js"></script>
    <script>
        
        
        
        window.onload = checkUserState();
        
    </script>
    </body>
</html>
