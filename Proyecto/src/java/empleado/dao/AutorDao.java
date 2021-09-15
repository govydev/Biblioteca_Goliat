package empleado.dao;

import empleado.bean.Autor;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutorDao extends Conexion {
    
    //Funcion para listar un autor 
    public ArrayList<Autor> listar() {
        ArrayList<Autor> list = new ArrayList<>();
        Autor ls;
        String sql = "SELECT* from autor";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                ls = new Autor();
                ls.setIdautor(rs.getInt(1));
                ls.setNombres(rs.getString(2));
                ls.setApellidos(rs.getString(3));
                list.add(ls);
            }
            return list;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    //Funcion para buscar un autor  por el id
    public Autor buscar(int id) {
        Autor c = null;
        String sql = "select * from autor where idautor = " + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                c = new Autor();
                c.setIdautor(rs.getInt(1));
                c.setNombres(rs.getString(2));
                c.setApellidos(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
    }

    //Funcion para modificar los datos de un autor
    public void modificar(Autor autor) {
        String sql = "update autor set nombres=?, apellidos=? where idautor=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, autor.getNombres());
            stm.setString(2, autor.getApellidos());
            stm.setInt(3, autor.getIdautor());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Funcion para agregar un nuevo autor 
    public void agregar(Autor autor) {
        String sql = "insert into autor(nombres,apellidos) values (?,?)";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, autor.getNombres());
            stm.setString(2, autor.getApellidos());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Funcion para eliminar un autor
    public void eliminar(int id) {
        String sql = "delete from autor where idautor=" + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
