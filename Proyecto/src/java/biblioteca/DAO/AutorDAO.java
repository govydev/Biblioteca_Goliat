package biblioteca.DAO;

import biblioteca.bean.Autor;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutorDAO extends Conexion {
    
    //Funcion de listar los autores de la base de datos
    public ArrayList<Autor> listarAutor() {
        ArrayList<Autor> list = new ArrayList<>();
        Autor ls;
        //Sentencia SQL
        String sql = "SELECT nombres, apellidos from autor";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de datos
            while (rs.next()) {
                ls = new Autor();
                ls.setNombres(rs.getString(1));
                ls.setApellidos(rs.getString(2));
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
}
