/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author PERSONAL
 */
@WebServlet(name = "rpMantenimiento", urlPatterns = {"/rpMantenimiento"})
public class rpMantenimiento extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, JRException {
        response.setContentType("text/html;charset=UTF-8");
        try (ServletOutputStream out = response.getOutputStream()) {

            // parametros de conexion a la base de datos 
            java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("ec.edu.espoch.accesoDatos.database");
            String URL = Configuracion.getString("url");
            String DRIVER = Configuracion.getString("driver");
            String USER = Configuracion.getString("user");
            String PASS = Configuracion.getString("password");
            Connection conexion;
            conexion = DriverManager.getConnection(URL, USER, PASS);
            ServletContext application = getServletContext();
            
            File reportFile = new File(application.getRealPath("reportes/report1.jasper"));
          
                Map parameters = new HashMap();
                parameters.put("cedula", (request.getParameter("pcedula").toString()));
                parameters.put("periodo", (request.getParameter("pperiodo").toString()));
                //parameters.put("banner", bannerStream);
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                out.write(bytes, 0, bytes.length);
                out.flush();
                out.close();
       

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(rpMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
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
