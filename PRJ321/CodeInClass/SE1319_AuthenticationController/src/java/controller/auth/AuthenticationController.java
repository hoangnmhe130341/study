/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.auth;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import util.CookieHelper;
import util.SessionHelper;

/**
 *
 * @author sonnt
 */
public class AuthenticationController extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        DBContext db = new DBContext();
        Account account = db.getAccountByUsernameAndPassword(username, password);
        if(account != null)
        {
            SessionHelper.addAccountToSession(request.getSession(), account);
            if(remember!=null)
            {
                CookieHelper.sendCookie(response, "username", account.getUsername());
                CookieHelper.sendCookie(response, "password", account.getPassword());
            }
            response.getWriter().println("Login successful!");
        }
        else
        {
            response.getWriter().println("Login failed!");
        }
    }

    

}
