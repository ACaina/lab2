/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author caina
 */
import accesodatos.AccesoDatos;
import entidades.Causa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class FCausa {

        public static Causa obtenerCausaDadoCodigo(int codigo) throws Exception {
        Causa causa = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_buscar_por_id_causa(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                causa = new Causa();
                causa.setId_causa(resultSet.getInt("id_causa"));
                causa.setNombre_causa(resultSet.getString("nombre_causa"));
                causa.setTitulo(resultSet.getString("titulo"));
                causa.setId_causa_rec(resultSet.getInt("id_causa_rec"));
                causa.setId_problema(FProblema.obtenerProbelmaDadoCodigo(resultSet.getInt("id_problema")));
//                causa.setId_causa_rec(obtenerCausaDadoCodigo(resultSet.getInt("id_causa_rec")));
//                causa.setSubActividad(FSubActividad.obtenerSubActividadDadoCodigo(resultSet.getInt("id_sub_actividad")));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return causa;
    }
    
    
    public static ArrayList<Causa> obtenerCausas() throws Exception {
        ArrayList<Causa> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Causa causa;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from arbol.f_seleccionar_causa()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                causa = new Causa();
                causa.setId_causa(resultSet.getInt("id_causa"));
                causa.setNombre_causa((resultSet.getString("nombre_causa")));
                causa.setTitulo((resultSet.getString("titulo")));
                causa.setId_causa_rec((resultSet.getInt("id_causa_rec")));
                causa.setId_problema(FProblema.obtenerProbelmaDadoCodigo(resultSet.getInt("id_problema")));
                lst.add(causa);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static String insertarCausa(Causa causa) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_insertar_causa(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, causa.getNombre_causa());
            prstm.setString(2, causa.getTitulo());
            prstm.setInt(3, causa.getId_causa_rec());
            prstm.setInt(4, causa.getId_problema().getId_problema());
//            prstm.setInt(3, causa.getId_causa_rec().getId_causa());
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

    public static String actualizarCausa(Causa causa) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_actualizar_causa(?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, causa.getId_causa());
            prstm.setString(2, causa.getNombre_causa());
            prstm.setString(3, causa.getTitulo());
            prstm.setInt(4, causa.getId_causa_rec());
            prstm.setInt(5,causa.getId_problema().getId_problema());
//            prstm.setInt(4, causa.getId_causa_rec().getId_causa());
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

    public static String eliminarCausa(Causa causa) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_eliminar_causa(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, causa.getId_causa());
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

