/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Models.AccountService;
import Models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class LoginServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String action = request.getParameter("action"); //Use getParameter() method 
        
        if(action != null && action.equals("logout")) //doesn't support "==" for comparing ?
        {
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        if(username != null){
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username == null || username.equals("") || password == null || password.equals(""))
        {
            request.setAttribute("message", "Please enter Username and Password!");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }else
        {
            HttpSession session = request.getSession();
            AccountService as = new AccountService();
            User usr = as.login(username, password);
            
            if(usr != null){
                session.setAttribute("username", usr.getName());
                request.setAttribute("username", usr.getName());
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);
            }else{
                request.setAttribute("username", username);
                request.setAttribute("message", "Failed authentication!");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            }
        }
    }
}
