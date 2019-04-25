/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.usercontroller;

import baohq.bean.JavaBean_User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class LoginController extends HttpServlet {

    private static final String ADMIN = "admin/admin.jsp";
    private static final String USER = "CusShowProductController";
    private static final String FAILED = "index.jsp";

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
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            JavaBean_User bean = new JavaBean_User();
            bean.setPassword(password);
            bean.setUsername(username);
            String role = bean.checkLogin();
            if (role.equals("failed")) {
                request.setAttribute("ERROR", "Invalid Username or Password!");
                url = FAILED;
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("USER", username);
                if (role.equals("Admin")) {
                    url = ADMIN;
                } else if (role.equals("Customer")) {
                    url = USER;
                } else {
                    request.setAttribute("ERROR", "Your role is not existed!");
                }
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
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
