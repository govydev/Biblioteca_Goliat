package empleado.dao;

import biblioteca.conexion.Conexion;
import empleado.bean.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDao extends Conexion {

    //Funcion para listar las categorias 
    public ArrayList<Categoria> listar() {
        ArrayList<Categoria> categoria = new ArrayList<>();
        Categoria p;
        String sql = "select * from categoria";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                p = new Categoria();
                p.setIdcategoria(rs.getInt(1));
                p.setCategoria(rs.getString(2));
                categoria.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return categoria;
    }

    //Funcion para buscar una categoria por el id
    public Categoria buscar(int id) {
        Categoria p = null;
        String sql = "select * from categoria where idcategoria = " + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                p = new Categoria();
                p.setIdcategoria(rs.getInt(1));
                p.setCategoria(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }

    //Funcion para modificar los datos de una categoria 
    public void modificar(Categoria categoria) {
        String sql = "update categoria set categoria=? where idcategoria=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, categoria.getCategoria());
            stm.setInt(2, categoria.getIdcategoria());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Funcion para agregar una nueva categoria 
    public void agregar(Categoria categoria) {
        String sql = "insert into categoria(categoria) values (?)";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, categoria.getCategoria());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Funcion para eliminar una categoria 
    public void eliminar(int id) {
        String sql = "delete from categoria where idcategoria=" + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
