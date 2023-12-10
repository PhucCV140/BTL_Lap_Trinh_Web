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
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Product;

/**
 *
 * @author chuva
 */
public class BuyControlServlet extends HttpServlet {
   
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
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        if (acc != null) {
            Cookie arr[] = request.getCookies();
            List<Product> list=new ArrayList<>();
            DAO d=new DAO();
            for(Cookie o:arr){
                if(o.getName().equals("id")){
                    String txt[]=o.getValue().split("\\|");
                    for(String s:txt){
                        list.add(d.getProduct(s));
                    }
                }
            }
            if (!list.isEmpty()) {
                for(int i=0;i<list.size();i++){
                    int count=1;
                    for(int j=i+1;j<list.size();j++){
                        if(list.get(i).getId() == list.get(j).getId()){
                            count++;
                            list.remove(j);
                            j--;
                            list.get(i).setAmount(count);
                        }
                    }
                }
                for(Product p:list){
                    int AccountID=acc.getId();
                    int ProductID=p.getId();
                    int quantity=p.getAmount();
                    LocalDateTime byDateTime=LocalDateTime.now();
                    d.insertBuyProduct(AccountID, ProductID, quantity, byDateTime);
                    d.updateProductQuantity(ProductID, quantity);
                }
                for(Cookie o:arr){
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
                response.sendRedirect("home");
            }else {
                String alertMessage = "Giỏ hàng của bạn đang trống. Vui lòng thêm sản phẩm vào giỏ hàng trước khi mua hàng.";
                String redirectScript = "<script>alert('" + alertMessage + "'); window.location.href='home';</script>";
                response.getWriter().write(redirectScript);
            }
        }else {
            String alertMessage = "Bạn cần đăng nhập để mua hàng.";
            String redirectScript = "<script>alert('" + alertMessage + "'); window.location.href='home';</script>";
            response.getWriter().write(redirectScript);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
