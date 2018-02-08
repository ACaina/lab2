/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Erika
 */
public class Involucrado {
    
    private int id_involucrado;
    private String nombre_involucrado;
    private String quehacer;
    private String interes;
    private String fortalezas;
    private String limitaciones;
    private String tipo;
    private Problema id_problema;

    public Involucrado() {
        id_problema = new Problema();
    }

    public Involucrado(int id_involucrado, String nombre_involucrado, String quehacer, String interes, String fortalezas, String limitaciones, String tipo,Problema id_problema) {
        this.id_involucrado = id_involucrado;
        this.nombre_involucrado = nombre_involucrado;
        this.quehacer = quehacer;
        this.interes = interes;
        this.fortalezas = fortalezas;
        this.limitaciones = limitaciones;
        this.tipo = tipo;
        this.id_problema = id_problema;
    }

    public Problema getId_problema() {
        return id_problema;
    }

    public void setId_problema(Problema id_problema) {
        this.id_problema = id_problema;
    }

    public int getId_involucrado() {
        return id_involucrado;
    }

    public void setId_involucrado(int id_involucrado) {
        this.id_involucrado = id_involucrado;
    }

    public String getNombre_involucrado() {
        return nombre_involucrado;
    }

    public void setNombre_involucrado(String nombre_involucrado) {
        this.nombre_involucrado = nombre_involucrado;
    }

    public String getQuehacer() {
        return quehacer;
    }

    public void setQuehacer(String quehacer) {
        this.quehacer = quehacer;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getFortalezas() {
        return fortalezas;
    }

    public void setFortalezas(String fortalezas) {
        this.fortalezas = fortalezas;
    }

    public String getLimitaciones() {
        return limitaciones;
    }

    public void setLimitaciones(String limitaciones) {
        this.limitaciones = limitaciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
