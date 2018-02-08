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
import entidades.Involucrado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class FInvolucrado {

        public static Involucrado obtenerInvolucradoDadoCodigo(int codigo) throws Exception {
        Involucrado involucrado = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_buscar_por_id_involucrado(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                involucrado = new Involucrado();
                involucrado.setId_involucrado(resultSet.getInt("id_involucrado"));
                involucrado.setNombre_involucrado(resultSet.getString("nombre_involucrado"));
                involucrado.setQuehacer(resultSet.getString("quehacer"));
                involucrado.setInteres(resultSet.getString("interes"));
                involucrado.setFortalezas(resultSet.getString("fortalezas"));
                involucrado.setLimitaciones(resultSet.getString("limitaciones"));
                involucrado.setTipo(resultSet.getString("tipo"));
                involucrado.setId_problema(FProblema.obtenerProbelmaDadoCodigo(resultSet.getInt("id_problema")));
//                causa.setId_causa_rec(obtenerCausaDadoCodigo(resultSet.getInt("id_causa_rec")));
//                causa.setSubActividad(FSubActividad.obtenerSubActividadDadoCodigo(resultSet.getInt("id_sub_actividad")));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return involucrado;
    }
    
    
    public static ArrayList<Involucrado> obtenerInvolucrado() throws Exception {
        ArrayList<Involucrado> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Involucrado involucrado;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from arbol.f_seleccionar_involucrado()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                involucrado = new Involucrado();
                involucrado.setId_involucrado(resultSet.getInt("id_involucrado"));
                involucrado.setNombre_involucrado(resultSet.getString("nombre_involucrado"));
                involucrado.setQuehacer(resultSet.getString("quehacer"));
                involucrado.setInteres(resultSet.getString("interes"));
                involucrado.setFortalezas(resultSet.getString("fortalezas"));
                involucrado.setLimitaciones(resultSet.getString("limitaciones"));
                involucrado.setTipo(resultSet.getString("tipo"));
                involucrado.setId_problema(FProblema.obtenerProbelmaDadoCodigo(resultSet.getInt("id_problema")));
                lst.add(involucrado);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static String insertarInvolucrado(Involucrado involucrado) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_insertar_involucrado(?,?,?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, involucrado.getNombre_involucrado());
            prstm.setString(2, involucrado.getQuehacer());
            prstm.setString(3, involucrado.getInteres());
            prstm.setString(4, involucrado.getFortalezas());
            prstm.setString(5, involucrado.getLimitaciones());
            prstm.setString(6, involucrado.getTipo());
            prstm.setInt(7, involucrado.getId_problema().getId_problema());
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

    public static String actualizarInvolucrado(Involucrado involucrado) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_actualizar_involucrado(?,?,?,?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, involucrado.getId_involucrado());
            prstm.setString(2, involucrado.getNombre_involucrado());
            prstm.setString(3, involucrado.getQuehacer());
            prstm.setString(4, involucrado.getInteres());
            prstm.setString(5, involucrado.getFortalezas());
            prstm.setString(6, involucrado.getLimitaciones());
            prstm.setString(7, involucrado.getTipo());
            prstm.setInt(8, involucrado.getId_problema().getId_problema());
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

    public static String eliminarInvolucrado(Involucrado involucrado) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_eliminar_involucrado(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, involucrado.getId_involucrado());
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

