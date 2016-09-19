/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.taller.User;
import com.taller.UserManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danielordonez
 */
@WebServlet(name = "ControlerServlet", urlPatterns = {"/ControlerServlet"})
public class ControlerServlet extends HttpServlet {

       
    private static final long serialVersionUID = 1232541L;
    
    User loggedUser = null;
    
    public ControlerServlet() {
        super();
        UserManager.initializeTestUsers();
    }
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        
        loggedUser = (User) request.getAttribute("user");
        
        if (loggedUser != null) {
            //Mostrar app
            rd = request.getRequestDispatcher("/loggedIn.jsp");
            //User user = new User(username, password);
            //request.setAttribute("user", user);
        } else {
            rd = request.getRequestDispatcher("/index.jsp");
        }
        
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher rd = null;
        //Si el botón presionado fue el de login ...
        if (request.getParameter("login") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            loggedUser = UserManager.authenticateUser(username);
            
            if (loggedUser != null) {
                rd = request.getRequestDispatcher("/main.jsp");
                request.setAttribute("user", loggedUser);
            } else {
                rd = request.getRequestDispatcher("/index.jsp");
            }
            
        } else if (request.getParameter("logout") != null) {
            //loggedIn = (User) request.getAttribute("user");
            
            if (UserManager.logout(loggedUser)) {
                loggedUser = null;
                request.setAttribute("user", null);
            }
            
            rd = request.getRequestDispatcher("/index.jsp");
            
        }
        
        else if ( request.getParameter("onlinelist") != null)
        {
            rd = request.getRequestDispatcher("/main.jsp");
            ArrayList<User> arr = UserManager.getConnectedUsers();
            
            request.setAttribute("onlineusers", arr);

        }
        
        rd.forward(request, response); 
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
