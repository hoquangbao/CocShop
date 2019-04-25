/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.ordercontroller;

import baohq.bean.JavaBean_Order;
import baohq.dto.OrderDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class InsertCartController extends HttpServlet {
    private static final String SUCCESS = "buy_success.jsp";
    private static final String FAIL = "viewcart.jsp";
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
        String url = null;
        try {
            JavaBean_Order bean = new JavaBean_Order();
            String username = request.getParameter("username");
            int order = bean.generateOrderID();
            String orderID = "O"  + "_"+ order;
            float total = Float.parseFloat(request.getParameter("txtTotal"));
            OrderDTO dto = new OrderDTO(orderID, username, total);
            bean.setDto(dto);
            
            String[] productID = request.getParameterValues("txtProductID");
            String[] productName = request.getParameterValues("txtProductName");
            String[] quantity = request.getParameterValues("txtQuantity");
            bean.setProductID(productID);
            bean.setProductName(productName);
            bean.setQuantity(quantity);
            bean.setOrderID(orderID);
            bean.setTotal(total);
            
            if(bean.insertOrder()){
                bean.insertBill();
                request.setAttribute("SUCCESS", "Buy Successfully");
                url = SUCCESS;
            }else{
                request.setAttribute("ERROR", "Buy Unsuccesfully");
                url = FAIL;
            }
        } catch (Exception e) {
            log("Error at InsertCartController: " + e.getMessage());
        } finally{
            request.getRequestDispatcher(url).forward(request, response);
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
