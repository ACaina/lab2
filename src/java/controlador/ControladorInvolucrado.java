/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Involucrado;
import modelo.FInvolucrado;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recurso.Util;
/**
 *
 * @author caina
 */ 
@ManagedBean
@ViewScoped
public class ControladorInvolucrado {
    private ArrayList<Involucrado> lstInvolucrado;
    private Involucrado objInvolucrado;
    private Involucrado InvolucradoSel;
    private String msgBD;
    

    public ControladorInvolucrado() {
        objInvolucrado = new Involucrado();
        InvolucradoSel = new Involucrado();
        obtenerInvolucrado();
    }

    public void obtenerInvolucrado() {
        try {
            lstInvolucrado = FInvolucrado.obtenerInvolucrado();
            System.out.println("total Involucrado: "+lstInvolucrado.size());
        } catch (Exception e) {
            System.out.println("public void obtenerInvolucrado() dice: "+e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            msgBD = FInvolucrado.insertarInvolucrado(objInvolucrado);
            objInvolucrado = new Involucrado();
            obtenerInvolucrado();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblInvolucrado");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarInvolucrado').hide()");
        } catch (Exception e) {
            
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            System.out.println("Entra actualizar");         
            msgBD = FInvolucrado.actualizarInvolucrado(InvolucradoSel);
            InvolucradoSel = new Involucrado();
            System.out.println("222");
            obtenerInvolucrado();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblInvolucrado");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarInvolucrado').hide()");
        } catch (Exception e) {
            System.out.println("actualizar() dijo: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

     public void eliminar() {
        try {
            msgBD = FInvolucrado.eliminarInvolucrado(InvolucradoSel);
            InvolucradoSel = new Involucrado();
            obtenerInvolucrado();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblInvolucrado");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarInvolucrado').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    
    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Involucrado> getLstInvolucrado() {
        return lstInvolucrado;
    }

    public void setLstInvolucrado(ArrayList<Involucrado> lstInvolucrado) {
        this.lstInvolucrado = lstInvolucrado;
    }

    public Involucrado getObjInvolucrado() {
        return objInvolucrado;
    }

    public void setObjInvolucrado(Involucrado objInvolucrado) {
        this.objInvolucrado = objInvolucrado;
    }

    public Involucrado getInvolucradoSel() {
        return InvolucradoSel;
    }

    public void setInvolucradoSel(Involucrado InvolucradoSel) {
        this.InvolucradoSel = InvolucradoSel;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }
    
    
    
}
