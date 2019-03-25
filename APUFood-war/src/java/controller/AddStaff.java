/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StaffDetails;
import model.StaffDetailsFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "AddStaff", urlPatterns = {"/AddStaff"})
public class AddStaff extends HttpServlet {


    @EJB
    private StaffDetailsFacade staffDetailsFacade;
    
    

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
         //String id, String password, String staffname, char gender, int phone, String ic, String email, String address
        String staffid =request.getParameter("staffid"); 
        String staffpass = request.getParameter("staffpassword");
        String staffname = request.getParameter("staffname");
        char staffgender =  request.getParameter("staffgender").charAt(0);
        int staffphone = Integer.parseInt(request.getParameter("staffphone"));
        String staffic = request.getParameter("staffic");
        String staffemail = request.getParameter("staffemail");
        String staffaddress = request.getParameter("staffaddress");
        char staffrole =  request.getParameter("staffrole").charAt(0);
        String staffstatus = "Available";
        
        
            StaffDetails a = new StaffDetails(staffid,staffpass,staffname,staffgender,staffphone,staffic,staffemail,staffaddress, staffrole, staffstatus);
            
            staffDetailsFacade.create(a);
        
        
       
        
        
        
//           Long id, String orderdatetime, int price, String address, char status, int quantity, UserAccount b, FoodDetails a) 
            
        
        
        request.getRequestDispatcher("Staff").include(request, response);
        
        
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
        processRequest(request, response);
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