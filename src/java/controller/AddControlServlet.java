/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Account;
import model.Category;

/**
 *
 * @author chuva
 */
public class AddControlServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        String pname=request.getParameter("name");
//        String pimage=request.getParameter("image");
//        String pprice=request.getParameter("price");
//        String ptitle=request.getParameter("title");
//        String pdescription=request.getParameter("description");
//        String pcategory=request.getParameter("category");
//        HttpSession session=request.getSession();
//        Account a=(Account) session.getAttribute("acc");
//        int sid=a.getId();
//        DAO d=new DAO();
//        d.insertProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, sid);
//        response.sendRedirect("manager");
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        DAO d=new DAO();
        List<Category> listc=d.getAllCategory();
        request.setAttribute("listC", listc);
        request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        String pname=request.getParameter("name");
        String pimage=request.getParameter("image");
        String pprice=request.getParameter("price");
        String amount=request.getParameter("amount");
        String ptitle=request.getParameter("title");
        String pdescription=request.getParameter("description");
        String pcategory=request.getParameter("category");
        HttpSession session=request.getSession();
        Account a=(Account) session.getAttribute("acc");
        int sid=a.getId();
        DAO d=new DAO();
        d.insertProduct(amount, pname, pimage, pprice, ptitle, pdescription, pcategory, sid);
        response.sendRedirect("manager");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
