package biblioteca.DAO;

import biblioteca.bean.Autor;
import biblioteca.bean.Categoria;
import biblioteca.bean.Genero;
import biblioteca.bean.Producto;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO extends Conexion {

    //Funcion para listar los productos segun la categoria 
    public ArrayList<Producto> listCat(String cat) {
        ArrayList<Producto> lspro = new ArrayList<>();
        Producto lst;
        //Sentencia SQL
        String sql = "select p.idproducto, p.titulo, p.fechaPublicacion, a.nombres,a.apellidos, g.genero from producto p ,autor a,genero g, categoria c where p.idautor=a.idautor and p.idgenero=g.idgenero and g.idcategoria=c.idcategoria and c.categoria='" + cat + "'";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de datos
            while (rs.next()) {
                lst = new Producto();
                lst.setIdproducto(rs.getInt("p.idproducto"));
                lst.setTitulo(rs.getString("p.titulo"));
                lst.setFechaPublicacion(rs.getDate("p.fechaPublicacion"));
                lst.setAutor(new Autor(rs.getString("a.nombres"), rs.getString("a.apellidos")));
                lst.setGenero(new Genero(rs.getString("g.genero")));
                lspro.add(lst);
            }
            return lspro;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    //Funcion para listar los productos disponibles 
    public ArrayList<Producto> listPro() {
        ArrayList<Producto> lspro = new ArrayList<>();
        Producto lst;
        //Sentencia SQL
        String sql = "select p.idproducto, p.titulo, p.fechaPublicacion, a.nombres,a.apellidos, g.genero from producto p ,autor a,genero g, categoria c where p.idautor=a.idautor and p.idgenero=g.idgenero and g.idcategoria=c.idcategoria;";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos 
            while (rs.next()) {
                lst = new Producto();
                lst.setIdproducto(rs.getInt("p.idproducto"));
                lst.setTitulo(rs.getString("p.titulo"));
                lst.setFechaPublicacion(rs.getDate("p.fechaPublicacion"));
                lst.setAutor(new Autor(rs.getString("a.nombres"), rs.getString("a.apellidos")));
                lst.setGenero(new Genero(rs.getString("g.genero")));
                lspro.add(lst);
            }
            return lspro;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    //Funcion para listar los productos segun el genero
    public ArrayList<Producto> listGen(String gen) {
        ArrayList<Producto> lsgen = new ArrayList<>();
        Producto lst;
        //Sentencia SQL
        String sql = "select p.idproducto, p.titulo, p.fechaPublicacion, a.nombres,a.apellidos, g.genero from producto p ,autor a,genero g, categoria c where p.idautor=a.idautor and p.idgenero=g.idgenero and g.idcategoria=c.idcategoria and g.genero='" + gen + "'";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos 
            while (rs.next()) {
                lst = new Producto();
                lst.setIdproducto(rs.getInt("p.idproducto"));
                lst.setTitulo(rs.getString("p.titulo"));
                lst.setFechaPublicacion(rs.getDate("p.fechaPublicacion"));
                lst.setAutor(new Autor(rs.getString("a.nombres"), rs.getString("a.apellidos")));
                lst.setGenero(new Genero(rs.getString("g.genero")));
                lsgen.add(lst);
            }
            return lsgen;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    //Funcion para listar los productos segun el titulo
    public ArrayList<Producto> listTitle(String title) {
        ArrayList<Producto> lsgen = new ArrayList<>();
        Producto lst;
        //Sentencia SQL
        String sql = "select p.idproducto, p.titulo, p.fechaPublicacion, a.nombres,a.apellidos, g.genero from producto p ,autor a,genero g, categoria c where p.idautor=a.idautor and p.idgenero=g.idgenero and g.idcategoria=c.idcategoria and p.titulo like '" + title + "%'";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos 
            while (rs.next()) {
                lst = new Producto();
                lst.setIdproducto(rs.getInt("p.idproducto"));
                lst.setTitulo(rs.getString("p.titulo"));
                lst.setFechaPublicacion(rs.getDate("p.fechaPublicacion"));
                lst.setAutor(new Autor(rs.getString("a.nombres"), rs.getString("a.apellidos")));
                lst.setGenero(new Genero(rs.getString("g.genero")));
                lsgen.add(lst);
            }
            return lsgen;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    //Funcion para listar productos segun su autor 
    public ArrayList<Producto> listAutor(String aut) {
        ArrayList<Producto> lspro = new ArrayList<>();
        Producto lst;
        //Sentencia SQL
        String sql = "select p.idproducto, p.titulo, p.fechaPublicacion, a.nombres,a.apellidos, g.genero from producto p ,autor a,genero g, categoria c where p.idautor=a.idautor and p.idgenero=g.idgenero and g.idcategoria=c.idcategoria and a.nombres='" + aut + "'";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos resultantes
            while (rs.next()) {
                lst = new Producto();
                lst.setIdproducto(rs.getInt("p.idproducto"));
                lst.setTitulo(rs.getString("p.titulo"));
                lst.setFechaPublicacion(rs.getDate("p.fechaPublicacion"));
                lst.setAutor(new Autor(rs.getString("a.nombres"), rs.getString("a.apellidos")));
                lst.setGenero(new Genero(rs.getString("g.genero")));
                lspro.add(lst);
            }
            return lspro;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    //Lista el producto segun el id que posee 
    public ArrayList<Producto> lista(int id) {
        ArrayList<Producto> lsgen = new ArrayList<>();
        Producto lst;
        //Sentencia SQL
        String sql = "select p.idproducto, p.titulo, p.fechaPublicacion, a.nombres,a.apellidos, g.genero , c.categoria, p.sinopsis, p.direccion from producto p ,autor a,genero g, categoria c where p.idautor=a.idautor and p.idgenero=g.idgenero and g.idcategoria=c.idcategoria and p.idproducto=" + id;
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos
            while (rs.next()) {
                lst = new Producto();
                lst.setIdproducto(rs.getInt("p.idproducto"));
                lst.setTitulo(rs.getString("p.titulo"));
                lst.setFechaPublicacion(rs.getDate("p.fechaPublicacion"));
                lst.setAutor(new Autor(rs.getString("a.nombres"), rs.getString("a.apellidos")));
                lst.setGenero(new Genero(rs.getString("g.genero"), new Categoria(rs.getString("c.categoria"))));
                lst.setSinopsis(rs.getString("p.sinopsis"));
                lst.setEnlace(rs.getString("p.direccion"));
                lsgen.add(lst);
            }
            return lsgen;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }
}
