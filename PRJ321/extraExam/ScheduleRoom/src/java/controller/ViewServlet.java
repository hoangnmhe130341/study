/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.RoomDAO;
import dal.ScheduleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Room;
import model.Schedule;

/**
 *
 * @author hoangnm
 */
@WebServlet(name = "BookRoomServlet", urlPatterns = {"/view"})
public class ViewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            LocalDate start = LocalDate.parse(request.getParameter("from"));
            LocalDate end = LocalDate.parse(request.getParameter("to"));

            List<LocalDate> listDate = new ArrayList<>();
            for (LocalDate date = start; date.isBefore(end.plusDays(1)); date = date.plusDays(1)) {
                listDate.add(date);
            }

            ArrayList<Room> listFreeRoom = new RoomDAO().getAllFreeRoom(Date.valueOf(start), Date.valueOf(end));
            ArrayList<Room> listBookedRoom = new RoomDAO().getAllBookedRoom(Date.valueOf(start), Date.valueOf(end));
            listFreeRoom.forEach((r) -> {
                r.setSchedule(new ScheduleDAO().getAllByRoomId(r.getId()));
            });
            listBookedRoom.forEach((r) -> {
                r.setSchedule(new ScheduleDAO().getAllByRoomId(r.getId()));
            });
            request.setAttribute("listDate", listDate);
            request.setAttribute("listFreeRoom", listFreeRoom);
            request.setAttribute("listBookedRoom", listBookedRoom);
            request.getRequestDispatcher("view.jsp").forward(request, response);
        }
    }

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
        request.getRequestDispatcher("view.jsp").forward(request, response);
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
        processRequest(request, response);
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
