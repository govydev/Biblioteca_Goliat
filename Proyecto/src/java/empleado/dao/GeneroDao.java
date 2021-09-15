package empleado.dao;

import biblioteca.conexion.Conexion;
import empleado.bean.Genero;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneroDao extends Conexion {
    
    //Funcion de para listar genero
    public ArrayList<Genero> listar() {
        ArrayList<Genero> genero = new ArrayList<>();
        Genero g;
        String sql = "select g.idgenero, g.genero, g.idcategoria, c.categoria from genero g, categoria c where g.idcategoria=c.idcategoria";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                g = new Genero();
                g.setIdgenero(rs.getInt(1));
                g.setGenero(rs.getString(2));
                g.setIdcategoria(rs.getInt(3));
                g.setCategoria(rs.getString(4));
                genero.add(g);
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
        return genero;
    }

    //Funcion para buscar un genero por el id 
    public Genero buscar(int id) {
        Genero g = null;
        String sql = "select * from genero where idgenero = " + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                g = new Genero();
                g.setIdgenero(rs.getInt(1));
                g.setGenero(rs.getString(2));
                g.setIdcategoria(rs.getInt(3));
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
        return g;
    }

    //Funcion para modificar los datos de un genero
    public void modificar(Genero genero) {
        String sql = "update genero set genero=?, idcategoria=? where idgenero=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, genero.getGenero());
            stm.setInt(3, genero.getIdcategoria());
            stm.setInt(3, genero.getIdgenero());
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

    //Funcion para agregar un nuevo genero
    public void agregar(Genero editorial) {
        String sql = "insert into genero(genero,idcategoria) values (?,?)";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, editorial.getGenero());
            stm.setInt(2, editorial.getIdcategoria());
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

    //Funcion para eliminar genero por el id 
    public void eliminar(int id) {
        String sql = "delete from genero where idgenero=" + id + " ";
        cn = abrir();

        try {
            stm = cn.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
