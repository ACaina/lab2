/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author caina
 */
public class Causa {

    private int id_causa;
    private String nombre_causa;
    private String titulo;
    private int id_causa_rec;
    private Problema id_problema;

    public Causa() {
        id_problema = new Problema();
    }

    public Causa(int id_causa, String nombre_causa, String titulo, int id_causa_rec, Problema id_problema) {
        this.id_causa = id_causa;
        this.nombre_causa = nombre_causa;
        this.titulo = titulo;
        this.id_causa_rec = id_causa_rec;
        this.id_problema = id_problema;
    }

    public int getId_causa() {
        return id_causa;
    }

    public void setId_causa(int id_causa) {
        this.id_causa = id_causa;
    }

    public String getNombre_causa() {
        return nombre_causa;
    }

    public void setNombre_causa(String nombre_causa) {
        this.nombre_causa = nombre_causa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId_causa_rec() {
        return id_causa_rec;
    }

    public void setId_causa_rec(int id_causa_rec) {
        this.id_causa_rec = id_causa_rec;
    }

    public Problema getId_problema() {
        return id_problema;
    }

    public void setId_problema(Problema id_problema) {
        this.id_problema = id_problema;
    }
    
    
    
}
