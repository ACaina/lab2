/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Usuario;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.FUsuario;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recurso.Util;
/**
 *
 * @author caina
 */ 
@ManagedBean
@ViewScoped
public class ControladorUsuario {
    private ArrayList<Usuario> lstUsuario;
    private Usuario objUsuario;
    private Usuario UsuarioSel;
    private String msgBD;
    

    public ControladorUsuario() {
        objUsuario = new Usuario();
        UsuarioSel = new Usuario();
        obtenerUsuario();
    }

    public void obtenerUsuario() {
        try {
            lstUsuario = FUsuario.obtenerUsuario();
            System.out.println("total Involucrado: "+lstUsuario.size());
        } catch (Exception e) {
            System.out.println("public void obtenerInvolucrado() dice: "+e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            msgBD = FUsuario.insertarUsuario(objUsuario);
            objUsuario = new Usuario();
            obtenerUsuario();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblUsuario");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarUsuario').hide()");
        } catch (Exception e) {
            
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            System.out.println("Entra actualizar");         
            msgBD = FUsuario.actualizarUsuario(UsuarioSel);
            UsuarioSel = new Usuario();
            System.out.println("222");
            obtenerUsuario();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblUsuario");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarUsuario').hide()");
        } catch (Exception e) {
            System.out.println("actualizar() dijo: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

     public void eliminar() {
        try {
            msgBD = FUsuario.eliminarUsuario(UsuarioSel);
            UsuarioSel = new Usuario();
            obtenerUsuario();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblUsuario");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarUsuario').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    
    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(ArrayList<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public Usuario getUsuarioSel() {
        return UsuarioSel;
    }

    public void setUsuarioSel(Usuario UsuarioSel) {
        this.UsuarioSel = UsuarioSel;
    }

   

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }
    
    
    
}
