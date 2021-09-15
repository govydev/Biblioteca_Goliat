package empleado.dao;

import biblioteca.conexion.Conexion;
import empleado.bean.Libro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroDao extends Conexion {
    
    //Funcion que lista los libros(productos) de la base de datos
    public ArrayList<Libro> listar() {
        ArrayList<Libro> libro = new ArrayList<>();
        Libro l;
        String sql = "select l.idproducto, l.titulo, l.idautor, a.nombres, a.apellidos, l.idgenero, g.genero, l.ideditorial, e.editorial, l.fechaPublicacion, l.sinopsis, l.direccion from producto l, genero g, autor a, editorial e where l.idautor=a.idautor and l.idgenero=g.idgenero and l.ideditorial=e.ideditorial  order by idproducto";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                l = new Libro();
                l.setIdlibro(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setIdautor(rs.getInt(3));
                l.setAutor(rs.getString(4)+" "+rs.getString(5));
                l.setIdgenero(rs.getInt(6));
                l.setGenero(rs.getString(7));
                l.setIdeditorial(rs.getInt(8));
                l.setEditorial(rs.getString(9));
                l.setFechaPublicacion(rs.getString(10));
                l.setSinopsis(rs.getString(11));
                l.setEnlace(rs.getString(12));
                libro.add(l);
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
        return libro;
    }

    //Funcion para buscar un producto por el id  
    public Libro buscar(int id) {
        Libro l = null;
        String sql = "select * from producto where idProducto = " + id + " ";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                l = new Libro();
                l.setIdlibro(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setIdautor(rs.getInt(3));
                l.setIdgenero(rs.getInt(4));
                l.setIdeditorial(rs.getInt(5));
                l.setFechaPublicacion(rs.getString(6));
                l.setSinopsis(rs.getString(7));
                l.setEnlace(rs.getString(8));
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
        return l;
    }

    //Funcion para modificar los datos de algun libro 
    public void modificar(Libro libro) {
        String sql = "update producto set titulo=?, idautor=?, ideditorial=?, idgenero=?, fechapublicacion=?, sinopsis=?, direccion=? where idproducto=?";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, libro.getTitulo());
            stm.setInt(2, libro.getIdautor());
            stm.setInt(3, libro.getIdeditorial());
            stm.setInt(4, libro.getIdgenero());
            stm.setString(5, libro.getFechaPublicacion());
            stm.setString(6, libro.getSinopsis());
            stm.setString(7, libro.getEnlace());
            stm.setInt(8, libro.getIdlibro());
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

    //Funcion para agregar un libro nuevo
    public void agregar(Libro libro) {
        String sql = "insert into producto(titulo,idautor,ideditorial,idgenero,fechapublicacion,sinopsis) values (?,?,?,?,?,?)";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            stm.setString(1, libro.getTitulo());
            stm.setInt(2, libro.getIdautor());
            stm.setInt(3, libro.getIdeditorial());
            stm.setInt(4, libro.getIdgenero());
            stm.setString(5, libro.getFechaPublicacion());
            stm.setString(6, libro.getSinopsis());
            stm.setString(7, libro.getEnlace());
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

    //Funcion para eliminar un libro por el id
    public void eliminar(int id) {
        String sql = "delete from producto where idproducto=" + id + " ";
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
