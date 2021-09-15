package empleado.dao;

import biblioteca.conexion.Conexion;
import empleado.bean.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDao extends Conexion {

    //Funcion para listar clientes 
    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> cliente = new ArrayList<>();
        Cliente c;
        String sql = "select c.idcliente, c.nombres, c.apellidos, c.telefono, c.correo, c.idpais, p.pais, c.usuario, c.contraseña,c.estado from cliente c, pais p where c.idpais = p.idpais";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                c = new Cliente();
                c.setIdcliente(rs.getInt(1));
                c.setNombres(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setTelefono(rs.getString(4));
                c.setCorreo(rs.getString(5));
                c.setIdpais(rs.getInt(6));
                c.setPais(rs.getString(7));
                c.setUsuario(rs.getString(8));
                c.setContraseña(rs.getString(9));
                c.setEstado(rs.getInt(10));
                cliente.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
        return cliente;
    }

    //Funcion para buscar al cliente por el id
    public Cliente buscar(int id) {
        Cliente c = null;
        String sql = "select * from cliente where idcliente = " + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setIdcliente(rs.getInt(1));
                c.setNombres(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setTelefono(rs.getString(4));
                c.setCorreo(rs.getString(5));
                c.setIdpais(rs.getInt(6));
                c.setUsuario(rs.getString(7));
                c.setContraseña(rs.getString(8));
                c.setEstado(rs.getInt(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
    }

    //Funcion para modificar los clientes de los datos de los clientes
    public void modificar(Cliente cliente) {
        String sql = "update cliente set nombres=?, apellidos=?, telefono=?, correo=?, idpais=?, usuario=?, estado=? where idcliente=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, cliente.getNombres());
            stm.setString(2, cliente.getApellidos());
            stm.setString(3, cliente.getTelefono());
            stm.setString(4, cliente.getCorreo());
            stm.setInt(5, cliente.getIdpais());
            stm.setString(6, cliente.getUsuario());
            stm.setInt(7, cliente.getEstado());
            stm.setInt(8, cliente.getIdcliente());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Funcion parsa agregar un nuevo cliente 
    public void agregar(Cliente cliente) {
        String sql = "insert into cliente(nombres,apellidos,telefono,correo,idpais,usuario,contraseña,estado) values (?,?,?,?,?,?,?,?)";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, cliente.getNombres());
            stm.setString(2, cliente.getApellidos());
            stm.setString(3, cliente.getTelefono());
            stm.setString(4, cliente.getCorreo());
            stm.setInt(5, cliente.getIdpais());
            stm.setString(6, cliente.getUsuario());
            stm.setString(7, cliente.getContraseña());
            stm.setInt(8, '1');
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Funcion para eliminar un cliente atravez del id
    public void eliminar(int id) {
        String sql = "delete from cliente where idcliente=" + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
