package biblioteca.DAO;

import biblioteca.bean.Empleado;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;

public class EmpleadoDAO extends Conexion {
    
    //Funcion para buscar a un empleado o administrador especifico en la base de datos
    public Empleado buscarID(int id) {
        Empleado em = null;
        //Sentencia SQL
        String sql = "select*from empleado where idempleado=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            //Almacenamiento de los datos del empleado 
            if (rs.next()) {
                em = new Empleado();
                em.setIdempleado(rs.getInt(1));
                em.setNombres(rs.getString(2));
                em.setApellidos(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setCorreo(rs.getString(5));
                em.setIdpais(rs.getInt(6));
            }
            return em;
        } catch (SQLException ex) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }
}
