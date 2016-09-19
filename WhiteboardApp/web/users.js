/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkUserState () {
    if (!localStorage.getItem("username")) {return false;}
    if (localStorage.getItem("username").localeCompare("LOGGED_OUT") === 0) {
        
    } else {
        window.location = "main.jsp";
    }
    
    return false;
}

function login(username) {
    
    localStorage.setItem("username", username);
    console.log("logging in...");
    window.location = "main.jsp";
    
    
    return false;
    
}

function logout() {
    
    localStorage.setItem("username", "LOGGED_OUT");
    
    window.location = "index.jsp";
    
    return false;
}

