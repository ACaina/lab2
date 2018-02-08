/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Usuario;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelo.FUsuario;
import recurso.Util;

/**
 *
 * @author caina
 */
@RequestScoped
@ManagedBean
public class ControladorSesion {
    private Usuario usuario;
    private HttpServletRequest httpServletRequest;
    private FacesContext faceContext;
//    private FacesMessage facesMessage;

    public ControladorSesion() {
        usuario = new Usuario();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
    }

    public void iniciarSesion() throws IOException {
        try {
            Usuario usuarioLogueado = FUsuario.loginUsuario(usuario.getNombreusuario(), usuario.getContraseña());
            faceContext.getExternalContext().redirect("index.xhtml");
//            faceContext.getExternalContext().getSessionMap().put("sessionUsuario", usuarioLogueado);
//            
//            httpServletRequest.getSession().setAttribute("idUsuarioLog", usuarioLogueado.getIdusuario());
//            httpServletRequest.getSession().setAttribute("nombre", usuarioLogueado.getNombreusuario().toUpperCase());
//            httpServletRequest.getSession().setAttribute("usuarioLogueado", usuarioLogueado);
//            
//            int intIdUsuario = (int) httpServletRequest.getSession().getAttribute("idUsuario");
//            lstRoles = ServiciosRolUsuario.listarRolesUsuario(intIdUsuario);
            
//            Util.addSuccessMessage("total de roles: " + lstRoles.size());            
//            System.out.println("total de roles: " + lstRoles.size());
//        
//            if (lstRoles.size() >= 1) {
//                faceContext.getExternalContext().redirect("seguridad/selectRol.xhtml");
//                registarAcceso();
//            } else {
//
//            }
        } catch (Exception ex) {
            
            Util.addErrorMessage(ex.getMessage().replace("\n", "").replace("Hint:", ""));
        }
    }

    
//    public void cerrarSesion() throws Exception {
//        try {
//            int intIdUsuario = (int) httpServletRequest.getSession().getAttribute("idUsuarioLog");
//            String registro = ServiciosAccesosUsuario.registrarSalidaSistema(intIdUsuario);
//            System.out.println(registro);
//            httpServletRequest.getSession().removeAttribute("usLogueado");
//            httpServletRequest.getSession().removeAttribute("nombre");
//            httpServletRequest.getSession().removeAttribute("ultimaIp");
//            httpServletRequest.getSession().removeAttribute("ultimoAcceso");
//
//            System.gc();  //limpiar todo
//            FacesContext fc = FacesContext.getCurrentInstance();
//
//            Util.addSuccessMessage("Sesión cerrada");
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            session.invalidate();
//
//            fc.getExternalContext().redirect("/WebAppMunicipio");
//            fc.getExternalContext().invalidateSession();
//        } catch (Exception ex) {
//            Util.addErrorMessage(ex.getMessage().replace("\n", "").replace("Hint:", ""));
//        }
//    }



//    public void registarAcceso() {
//        try {
//            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//            String ipLocal = request.getRemoteAddr();
//            String hostname = request.getRemoteHost();
//            int intIdUsuario = (int) httpServletRequest.getSession().getAttribute("idUsuarioLog");
//            String registro = ServiciosAccesosUsuario.registrarAccesoSistema(intIdUsuario, ipLocal, ipLocal, hostname);
//            System.out.println(registro);
//
//        } catch (Exception e) {
//            System.out.println("public void registarAcceso() dice: " + e.getMessage());
//        }
//    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public FacesContext getFaceContext() {
        return faceContext;
    }

    public void setFaceContext(FacesContext faceContext) {
        this.faceContext = faceContext;
    }
    
    
    
}
