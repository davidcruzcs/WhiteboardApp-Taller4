/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taller;

import java.util.ArrayList;

      
/**
 *
 * @author Sergio
 */
public class UserManager {
      
        //All registered users
        private static ArrayList<User> users = new ArrayList<User>();
//Currently connected users
private static ArrayList<User> connectedUsers = new ArrayList<User>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<User> getConnectedUsers() {
        return connectedUsers;
    }
        
   public static void initializeTestUsers()
        {
            for (int i = 0; i < 10; i++)
            {
                String cadena = "usuario" + i;
                addUser(cadena);
            }
        }
        
        public static User addUser(String username)
        {
            User adding = new User(username);
            for (User u : users)
            {
                if (u.getUsername().equals(username))
                {
                   //User in the list
                   return null;
                    
                }
            }
            users.add( new User(username) );
            return adding;
        }
        public static boolean logout(User user)
        {
            for (User u : connectedUsers)
            {
                if (u.getUsername().equals(user.getUsername()))
                {
                    connectedUsers.remove(u);
                    return true;
                }
            }
            
            return false;
        }
        //Authenticate user to platform
        public static User authenticateUser(String username)
        {          
            for (User u : users)
            {
                if (u.getUsername().equals(username) )
                {
                    connectedUsers.add(u);
                    return u;
                }
            }
            
            return null;
        }
        
        public static boolean loggedIn(User user)
        {
            for (User u : connectedUsers)
            {
                if (u.getUsername().equals(user.getUsername()))
                {
                    return true;
                }
            }
            
            return false;
        }
        
        
}
