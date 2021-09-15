package empleado.dao;

import biblioteca.conexion.Conexion;
import empleado.bean.Pais;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaisDao extends Conexion {

    //Lista los paises de la base de datos
    public ArrayList<Pais> listar() {
        ArrayList<Pais> pais = new ArrayList<>();
        Pais p;
        //Sentencia SQL
        String sql = "select * from pais";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos
            while (rs.next()) {
                p = new Pais();
                p.setIdpais(rs.getInt(1));
                p.setPais(rs.getString(2));
                pais.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pais;
    }

    //Funcion que busca a un pais por el id 
    public Pais buscar(int id) {
        Pais p = null;
        //Sentencia SQL
        String sql = "select * from pais where idpais = " + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacena los datos del pais seleccionado
            if (rs.next()) {
                p = new Pais();
                p.setIdpais(rs.getInt(1));
                p.setPais(rs.getString(2));
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
        return p;
    }

    //Funcion para modificar los datos de pais
    public void modificar(Pais pais) {
        //Sentencia SQL
        String sql = "update pais set pais=? where idpais=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, pais.getPais());
            stm.setInt(2, pais.getIdpais());
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

    //Funcion para agregar un nuevo pais
    public void agregar(Pais pais) {
        //Sentencia SQL
        String sql = "insert into pais(pais) values (?)";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, pais.getPais());
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

    //Funcion para eliminar un pais mediante su id
    public void eliminar(int id) {
        //Sentencia SQL
        String sql = "delete from pais where idpais=" + id + " ";
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
