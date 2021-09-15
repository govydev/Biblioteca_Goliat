package biblioteca.DAO;

import biblioteca.bean.Empleado;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;

public class UsuarioEmpleadoDAO extends Conexion {

    //Funcion para validar el login del empleado o administrador 
    public Empleado validarUsuario(String us, String pas) {
        Empleado u = null;
        //Sentencia SQL
        String sql = "select*from empleado where usuario=? and contraseña=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, us);
            stm.setString(2, pas);
            rs = stm.executeQuery();
            //Almacenamiento de los datos del administrador
            if (rs.next()) {
                u = new Empleado();
                u.setIdempleado(rs.getInt(1));
                u.setNombres(rs.getString(2));
                u.setApellidos(rs.getString(3));
                u.setTelefono(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setIdpais(rs.getInt(6));
                u.setUsuario(rs.getString(7));
                u.setContraseña(rs.getString(8));
            }
            return u;
        } catch (SQLException ex) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }

    }
}
