/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recurso;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.DefaultRequestContext;

/**
 *
 * @author usuario
 */
@ManagedBean
@RequestScoped
public class rcUtil {

    /**
     * Creates a new instance of Util
     */
    public rcUtil() {
    }

    public static void mensajeExito(String dialog) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Exito", new FacesMessage("Datos Insertados Correctamente"));
        DefaultRequestContext.getCurrentInstance().execute(dialog);
    }

    public static void mensajeExitomodificar(String dialog) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Exito", new FacesMessage("Datos Modificados Correctamente"));
        DefaultRequestContext.getCurrentInstance().execute(dialog);
    }

    public static void mensajeExitoeliminar(String dialog) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Exito", new FacesMessage("Datos Eliminados Correctamente"));
        DefaultRequestContext.getCurrentInstance().execute(dialog);
    }

    public static void mensajeFracaso() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Fracaso", new FacesMessage("Datos No Insertados"));
    }

    public static void mensajeExcepcion(Exception e) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Exito", new FacesMessage(e.getMessage()));
    }

}
