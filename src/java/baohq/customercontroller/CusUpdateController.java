/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.customercontroller;

import baohq.bean.JavaBean_User;
import baohq.dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class CusUpdateController extends HttpServlet {
    private static final String UPDATE = "customer/updatecustomer.jsp";
    private static final String SUCCESS = "GetUserInfomation";
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
            String action = request.getParameter("action");
            JavaBean_User bean = new JavaBean_User();
            if(action.equals("Edit")){
                String value = request.getParameter("username");
                bean.setUsername(value);
                UserDTO list = bean.searchUserByPrimaryKey();
                request.setAttribute("INFO", list);
                url = UPDATE;
            }
            else if(action.equals("Update")){
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String email = request.getParameter("txtEmail");
                String role = request.getParameter("txtRole");
                UserDTO list = new UserDTO(username, password, email, role);
                bean.setDto(list);
                if(bean.updateUser()){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "Update fail!");
                    url = UPDATE;
                }
            }
            else{
                request.setAttribute("ERROR", "Action not supported!");
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at UpdateController: " + e.getMessage());
        }
        finally{
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
