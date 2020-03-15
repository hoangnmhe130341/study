/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.EmployeeDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 84963
 */
public class EmployeeUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        int id = Integer.parseInt(raw_id);
        EmployeeDAO empDB = new EmployeeDAO();
        request.setAttribute("emps", empDB.getEmpsByID(id));
        request.getRequestDispatcher("updateListJsp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date dob = Date.valueOf(request.getParameter("dob"));
        boolean gender = Boolean.valueOf(request.getParameter("gender"));
        int de_id = Integer.parseInt(request.getParameter("de_id"));
        EmployeeDAO em = new EmployeeDAO();
        em.updateEmpsByID(name, dob, gender, de_id, id);
        response.sendRedirect("list");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
