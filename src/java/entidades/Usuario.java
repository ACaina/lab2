/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author HP ENVY
 */
public class Usuario {
    private Integer idusuario;
    private String nombreusuario;
    private String contraseña;
    
    public Usuario()
    {
    }
    
    public Usuario(Integer idusuario, String nombreusuario,String contraseña)
    {
        this.idusuario=idusuario;
        this.nombreusuario=nombreusuario;
        this.contraseña=contraseña;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
  
}
