/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesodatos.AccesoDatos;
import entidades.Problema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Jackeline
 */
public class FProblema {
    public static Problema obtenerProbelmaDadoCodigo(int codigo) throws Exception {
        Problema problema = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_buscar_por_id_problema(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                problema = new Problema();
                problema.setId_problema(resultSet.getInt("id_problema"));
                problema.setDescripcion(resultSet.getString("descripcion"));
                problema.setId_usuario(FUsuario.obtenerUsuarioDadoCodigo(resultSet.getInt("id_usuario")));
                //                causa.setId_causa_rec(obtenerCausaDadoCodigo(resultSet.getInt("id_causa_rec")));
////                causa.setSubActividad(FSubActividad.obtenerSubActividadDadoCodigo(resultSet.getInt("id_sub_actividad")));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return problema;
    }
    
    public static ArrayList<Problema> obtenerProblema() throws Exception {
        ArrayList<Problema> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Problema problema;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from arbol.f_seleccionar_problema()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                problema = new Problema();
                problema.setId_problema(resultSet.getInt("id_problema"));
                problema.setDescripcion(resultSet.getString("descripcion"));
                problema.setId_usuario(FUsuario.obtenerUsuarioDadoCodigo(resultSet.getInt("id_usuario")));
                lst.add(problema);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
    public static String insertarProblema(Problema problema) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_insertar_problema(?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, problema.getDescripcion());
            prstm.setInt(2, problema.getId_usuario().getIdusuario());
            System.out.println("Pass");
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                res = resultSet.getString(1);
                System.out.println("Pasa res");
                return res;
            } else {
                System.out.println("Pasa null");
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public static String actualizarProblema(Problema problema) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_actualizar_problema(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, problema.getId_problema());
            prstm.setString(2, problema.getDescripcion());
            prstm.setInt(3, problema.getId_usuario().getIdusuario());
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
     public static String eliminarProblema(Problema problema) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_eliminar_problema(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, problema.getId_problema());
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
}
