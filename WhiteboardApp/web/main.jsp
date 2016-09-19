<%-- 
    Document   : index
    Created on : 18-sep-2016, 22:14:46
    Author     : juandavidcruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Whiteboard App</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <h5 style="position:absolute; right: 20px; top:20px" id="userNameHeader"></h5>
        <h4 style="position:absolute; right: 20px; top:20px" id="userNameHeader">${user.username}</h4>
        <button onclick="logout();" style="position: absolute; right:20px; top: 60px;">Logout!</button>
        
        <h1>Collaborative Whiteboard App</h1>
<!--    For Testing    <div id="output"></div>-->
<table>
        <tr>
            <td>
                <canvas id="myCanvas" width="150" height="150" style="border:1px solid #000000;"></canvas>
                <button onclick="downloadCanvas(this, 'myCanvas', 'download.png');">Download!</button>
            </td>
            <td>
                <form name="inputForm">
                    <table>

                            <tr>
                                <th>Color</th>
                                <td><input type="radio" name="color" value="#FF0000" checked="true">Red</td>
                                <td><input type="radio" name="color" value="#0000FF">Blue</td>
                                <td><input type="radio" name="color" value="#FF9900">Orange</td>
                                <td><input type="radio" name="color" value="#33CC33">Green</td>
                            </tr>

                            <tr>
                                <th>Shape</th>
                                <td><input type="radio" name="shape" value="square" checked="true">Square</td>
                                <td><input type="radio" name="shape" value="circle">Circle</td>
                                <td> </td>
                                <td> </td>
                            </tr>
                            
                            <tr>
    <th> </th>
    <td><input type="submit" value="Send Snapshot" onclick="defineImageBinary(); return false;"></td>
    <td><input type="checkbox" id="instant" value="Online" checked="true">Online</td>
    <td> </td>
    <td> </td>
</tr>

                        </table>

                </form>
            </td>
        </tr>
    </table>
 <c:forEach var="actual" items="${onlineusers}">
            ${actual.username}<br>
        </c:forEach>
    <script type="text/javascript" src="users.js"></script>
    <script type="text/javascript" src="websocket.js"></script>
    <script type="text/javascript" src="whiteboard.js"></script>
    <script>
    
        function getUserInfo() {
            var headerUser = document.getElementById("userNameHeader");
            headerUser.innerHTML = localStorage.getItem("username");
            
    
        }
        
        function downloadCanvas(link, canvasId, filename) {
            var canvas = document.getElementById("myCanvas");
            var img = canvas.toDataURL("image/png");
            window.open(img, "_blank");
        }
        
        window.onload = getUserInfo();
    
    </script>
    </body>
</html>
