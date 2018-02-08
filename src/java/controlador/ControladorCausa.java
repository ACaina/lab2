/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import entidades.Causa;
import modelo.FCausa;
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
public class ControladorCausa {
 
    private ArrayList<Causa> lstCausas;
    private Causa objCausa;
    private Causa causaSel;
    private String msgBD;
    

    public ControladorCausa() {
        objCausa = new Causa();
        causaSel = new Causa();
        obtenerCausa();
    }

    public void obtenerCausa() {
        try {
            lstCausas = FCausa.obtenerCausas();
            System.out.println("total Causas: "+lstCausas.size());
        } catch (Exception e) {
            System.out.println("public void obtenerCausas() dice: "+e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            msgBD = FCausa.insertarCausa(objCausa);
            objCausa = new Causa();
            obtenerCausa();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblCausa");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarCausa').hide()");
        } catch (Exception e) {
            
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            System.out.println("Entra actualizar");         
            msgBD = FCausa.actualizarCausa(causaSel);
            causaSel = new Causa();
            System.out.println("222");
            obtenerCausa();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblCausa");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarCausa').hide()");
        } catch (Exception e) {
            System.out.println("actualizar() dijo: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

     public void eliminar() {
        try {
            msgBD = FCausa.eliminarCausa(causaSel);
            causaSel = new Causa();
            obtenerCausa();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblCausa");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarCausa').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    
    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Causa> getLstCausas() {
        return lstCausas;
    }

    public void setLstCausas(ArrayList<Causa> lstCausas) {
        this.lstCausas = lstCausas;
    }

    public Causa getObjCausa() {
        return objCausa;
    }

    public void setObjCausa(Causa objCausa) {
        this.objCausa = objCausa;
    }

    public Causa getCausaSel() {
        return causaSel;
    }

    public void setCausaSel(Causa causaSel) {
        this.causaSel = causaSel;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }
}
