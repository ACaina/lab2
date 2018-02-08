/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Problema;
import entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.FProblema;
import modelo.FUsuario;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recurso.Util;

/**
 *
 * @author Jackeline
 */
@ManagedBean
@ViewScoped
public class ControladorProblema implements Serializable {

    private ArrayList<Problema> lstProblema;
    private ArrayList<Usuario> lstUsuario;
    private Problema objProblema;
    private Problema problemaSel;
    private String msgBD;

    public ControladorProblema() {
        objProblema = new Problema();
        problemaSel = new Problema();
        obtenerUsuario();
        obtenerProblema();
        
    }

    public void obtenerProblema() {
        try {
            lstProblema = FProblema.obtenerProblema();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerUsuario() {
        try {
            lstUsuario = FUsuario.obtenerUsuario();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            
            msgBD = FProblema.insertarProblema(objProblema);
            System.out.println("Pasa insert");
            objProblema = new Problema();
            obtenerProblema();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblProblema");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarProblema').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FProblema.actualizarProblema(problemaSel);
            problemaSel = new Problema();
            obtenerProblema();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblProblema");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarProblema').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FProblema.eliminarProblema(problemaSel);
            problemaSel = new Problema();
            obtenerProblema();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblProblema");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarProblema').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Problema> getLstProblema() {
        return lstProblema;
    }

    public void setLstProblema(ArrayList<Problema> lstProblema) {
        this.lstProblema = lstProblema;
    }

    public ArrayList<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(ArrayList<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public Problema getObjProblema() {
        return objProblema;
    }

    public void setObjProblema(Problema objProblema) {
        this.objProblema = objProblema;
    }

    public Problema getProblemaSel() {
        return problemaSel;
    }

    public void setProblemaSel(Problema problemaSel) {
        this.problemaSel = problemaSel;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }
}
