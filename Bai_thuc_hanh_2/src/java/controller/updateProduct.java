/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductIO;
import entity.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "updateProduct", urlPatterns = {"/updateProduct"})
public class updateProduct extends HttpServlet {

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
        String action = request.getParameter("action");
        if (action == null) {
            String id = request.getParameter("id");
            ProductIO p = new ProductIO();
            Product product = p.getProductById(id);
            request.setAttribute("product", product);
            request.setAttribute("code", product.getCode());
            request.setAttribute("description", product.getDescription());
            request.setAttribute("price", product.getPrice());
        } else {
            String id = request.getParameter("id");
            String description = request.getParameter("description");
            String s_price = request.getParameter("price");
            ProductIO p = new ProductIO();
            Product product = p.getProductById(id);
            request.setAttribute("code", product.getCode());
            request.setAttribute("description", description);
            request.setAttribute("price", s_price);
            if (description == null || s_price == null || description.trim().equalsIgnoreCase("") || s_price.trim().equalsIgnoreCase("")){
                request.setAttribute("notification", "You must fill the blank!");
            }
            else {
                try{
                    Double price = Double.parseDouble(s_price);
                    product.setDescription(description.trim());
                    product.setPrice(price);
                    ProductIO productIO = new ProductIO();
                    
                    productIO.updateProduct(product);
                    request.setAttribute("notification", "Update successfully");
                    request.setAttribute("product", product);
                }catch(NumberFormatException e){
                    request.setAttribute("notification", "The price must be number");
                }
            }
            
        }


        request.getRequestDispatcher("updateProduct.jsp").forward(request, response);

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
