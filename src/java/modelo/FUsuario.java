package modelo;

import accesodatos.AccesoDatos;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class FUsuario {

 public static Usuario obtenerUsuarioDadoCodigo(int codigo) throws Exception {
        Usuario usuario = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_buscar_por_id_usuario(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(resultSet.getInt("id_usuario"));
                usuario.setNombreusuario(resultSet.getString("nombre_usuario"));
                usuario.setContraseña(resultSet.getString("contrasenia"));
//                causa.setId_causa_rec(obtenerCausaDadoCodigo(resultSet.getInt("id_causa_rec")));
//                causa.setSubActividad(FSubActividad.obtenerSubActividadDadoCodigo(resultSet.getInt("id_sub_actividad")));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }

 public static ArrayList<Usuario> obtenerUsuario() throws Exception {
        ArrayList<Usuario> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Usuario usuario;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from arbol.f_seleccionar_usuario()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(resultSet.getInt("id_usuario"));
                usuario.setNombreusuario(resultSet.getString("nombre_usuario"));
                usuario.setContraseña(resultSet.getString("contrasenia"));
                lst.add(usuario);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
 
 public static String insertarUsuario(Usuario usuario) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_insertar_usuario(?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, usuario.getNombreusuario());
            prstm.setString(2, usuario.getContraseña());
//          prstm.setInt(3, causa.getId_causa_rec().getId_causa());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                res = resultSet.getString(1);
                return res;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }
public static String actualizarUsuario(Usuario usuario) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_actualizar_usuario(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, usuario.getIdusuario());
            prstm.setString(2, usuario.getNombreusuario());
            prstm.setString(3, usuario.getContraseña());
//          prstm.setInt(4, causa.getId_causa_rec().getId_causa());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                res = resultSet.getString(1);
                return res;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }
  public static String eliminarUsuario(Usuario usuario) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_eliminar_usuario(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, usuario.getIdusuario());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                res = resultSet.getString(1);
                return res;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }
  
      public static Usuario loginUsuario(String nombre, String contrasenia) throws Exception {
        Usuario usuario = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "SELECT * FROM arbol.f_sesion_usuario(?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, nombre);
            prstm.setString(2, contrasenia);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(resultSet.getInt("id_usuario"));
                usuario.setNombreusuario(resultSet.getString("nombre_usuario"));
                usuario.setContraseña(resultSet.getString("contrasenia"));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }
  
}
