/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entity;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import util.SessionHelper;

/**
 *
 * @author sonnt
 */
public abstract class BaseRequiredAuthenticationController extends HttpServlet {

    private boolean isAuthenticated(HttpServletRequest request)
    {
        Account account = SessionHelper.getAccountFromSession(request.getSession());
        if(account !=null)
            return true;
        else
        {
            Cookie[] cookies = request.getCookies();
            if(cookies ==null)
                return false;
            else
            {
                String username = null;
                String password = null;
                for (Cookie cooky : cookies) {
                    if(cooky.getName().equals("username"))
                        username = cooky.getValue();
                    if(cooky.getName().equals("password"))
                        password = cooky.getValue();
                    if(username!=null && password !=null)
                        break;  
                }
                if(username!=null && password !=null)
                {
                    DBContext db = new  DBContext();
                    account = db.getAccountByUsernameAndPassword(username, password);
                    if(account!=null)
                    {
                        SessionHelper.addAccountToSession(request.getSession(), account);
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                        
                }
            }
        }
        return false;
    }

    
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isAuthenticated(request))
        {
            processGet(request, response);
        }
        else
        {
            response.getWriter().println("access denied!");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isAuthenticated(request))
        {
            processPost(request, response);
        }
        else
        {
            response.getWriter().println("access denied!");
        }
    }



}
