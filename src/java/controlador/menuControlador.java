/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class menuControlador {

    private String ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void frmTipoMantenimiento() {
        this.ruta = "faces/vista/vTipomantenimiento.xhtml";
    }

    public void frmTipo() {
        this.ruta = "faces/vista/vTipo.xhtml";
    }

    public void frmFrecuencia() {
        this.ruta = "faces/vista/vFrecuencia.xhtml";
    }

    public void frmLaboratorio() {
        this.ruta = "faces/vista/vLaboratorio.xhtml";
    }

    public void frmComputadora() {
        this.ruta = "faces/vista/vComputadora.xhtml";
    }

    public void frmMantenimiento() {
        this.ruta = "faces/vista/vComputadoramantenimiento.xhtml";
    }

    public void frmFacultad() {
        this.ruta = "faces/vista/vFacultad.xhtml";
    }

    public void frmActividad() {
        this.ruta = "faces/vista/vActividad.xhtml";
    }

    public void frmComerciante() {
        this.ruta = "faces/vista/vComerciante.xhtml";
    }

    public void frmTipopagina() {
        this.ruta = "faces/vista/vTipopagina.xhtml";
    }
    
    public void frmtipopuesto() {
        this.ruta = "faces/vista/vtipopuesto.xhtml";
    }
    
    public void frmComprobante() {
        this.ruta = "faces/vista/vComprobante.xhtml";
    }
    
    public void frmCausa() {
        this.ruta = "faces/arbol/frmCausa.xhtml";
    }
    
    public void frmInvolucrado() {
        this.ruta = "faces/arbol/frmInvolucrado.xhtml";
    }
    
    public void frmUsuario() {
        this.ruta = "faces/arbol/frmUsuario.xhtml";
    }
    
    public void frmProblema() {
        this.ruta = "faces/arbol/frmProblema.xhtml";
    }
    
     public void frmJerarquia() {
        this.ruta = "faces/arbol/frmJerarquia.xhtml";
    }
    /**
     * Creates a new instance of menuControlador
     */
    public menuControlador() {
    }

}
