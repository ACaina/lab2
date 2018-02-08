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
public class Problema {

    private Integer id_problema;
    private String descripcion;
    private Usuario id_usuario;

    public Problema() {
        id_usuario = new Usuario();
    }

    public Problema(Integer id_problema, String descripcion, Usuario id_usuario) {
        this.id_problema = id_problema;
        this.descripcion = descripcion;
        this.id_usuario = id_usuario;
    }

    public Integer getId_problema() {
        return id_problema;
    }

    public void setId_problema(Integer id_problema) {
        this.id_problema = id_problema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
}
