package biblioteca.DAO;

import biblioteca.bean.Cliente;
import biblioteca.conexion.Conexion;
import empleado.dao.LibroDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO extends Conexion {
    
    //Funcion para mostrar un Cliente especifico de la base de datos
    public Cliente buscarID(int id) {
        Cliente em = null;
        //Sentencia SQL
        String sql = "select*from cliente where idcliente=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            //Almacenamiento de datos de un cliente especifico
            if (rs.next()) {
                em = new Cliente();
                em.setIdcliente(rs.getInt(1));
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

    //Funcion para agregar un nuevo cliente o usuario
    public void agregar(Cliente cliente) {
        cn = abrir();
        try {
            //Ejecucion de la sentencia SQL para agregar cliente
            stm = cn.prepareStatement("insert into cliente(nombres,apellidos,telefono,correo,idpais,usuario,contraseña,estado) values (?,?,?,?,?,?,?,?)");
            stm.setString(1, cliente.getNombres());
            stm.setString(2, cliente.getApellidos());
            stm.setString(3, cliente.getTelefono());
            stm.setString(4, cliente.getCorreo());
            stm.setInt(5, cliente.getIdpais());
            stm.setString(6, cliente.getUsuario());
            stm.setString(7, cliente.getPass());
            stm.setInt(8, cliente.getEstado());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar(cn);
            cerrar(stm);
        }
    }
}
