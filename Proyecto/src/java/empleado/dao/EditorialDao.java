package empleado.dao;

import biblioteca.conexion.Conexion;
import empleado.bean.Editorial;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditorialDao extends Conexion {

    //Funcion para listar editoriales 
    public ArrayList<Editorial> listar() {
        ArrayList<Editorial> editorial = new ArrayList<>();
        Editorial e;
        String sql = "select * from editorial";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                e = new Editorial();
                e.setIdeditorial(rs.getInt(1));
                e.setEditorial(rs.getString(2));
                editorial.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(EditorialDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return editorial;
    }

    //Funcion para buscar una editorial atravez del id
    public Editorial buscar(int id) {
        Editorial e = null;
        String sql = "select * from editorial where ideditorial = " + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                e = new Editorial();
                e.setIdeditorial(rs.getInt(1));
                e.setEditorial(rs.getString(2));
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
        return e;
    }

    //Funcion para modificar los datos de editorial
    public void modificar(Editorial editorial) {
        String sql = "update editorial set editorial=? where ideditorial=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, editorial.getEditorial());
            stm.setInt(2, editorial.getIdeditorial());
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

    //Funcion para agregar una nueva editorial
    public void agregar(Editorial editorial) {
        String sql = "insert into editorial(editorial) values (?)";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, editorial.getEditorial());;
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

    //Funcion para eliminar una editorial atravez del id
    public void eliminar(int id) {
        String sql = "delete from editorial where ideditorial=" + id + " ";
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
