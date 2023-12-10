/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import model.Voucher;

/**
 *
 * @author chuva
 */
public class ApplyVoucherServlet extends HttpServlet {

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
        String voucherId = request.getParameter("voucher");
        DAO d = new DAO();
        Voucher voucher = d.getVoucher(voucherId);
        if (voucher != null) {
            Cookie[] cookies = request.getCookies();
            String existingVouchers = "";
            boolean voucherAvailable = true;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("vouchers")) {
                        existingVouchers = cookie.getValue();
                        break;
                    }
                }
            }
            String newVoucher = existingVouchers;
            if (!existingVouchers.isEmpty()) {
                String[] ids = existingVouchers.split("\\|");
                if (Arrays.asList(ids).contains(voucherId)) {
                    voucherAvailable = false;
                }
            }
            if (voucherAvailable) {
                newVoucher = existingVouchers.isEmpty() ? voucherId : existingVouchers + "|" + voucherId;
                Cookie c = new Cookie("vouchers", newVoucher);
                c.setMaxAge(60 * 60 * 24);
                response.addCookie(c);
                response.sendRedirect("show");
            } else {
                response.getWriter().println("<script>alert('Voucher đã tồn tại trong giỏ hàng.'); window.location.href='show';</script>");
            }
        } else {
            response.getWriter().println("<script>alert('Voucher không tồn tại.'); window.location.href='show';</script>");
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
