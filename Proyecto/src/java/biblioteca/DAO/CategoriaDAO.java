package biblioteca.DAO;

import biblioteca.bean.Categoria;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO extends Conexion {

    //Funcion para listar las categorias de la base de datos
    public ArrayList<Categoria> listCategoria() {
        ArrayList<Categoria> lscat = new ArrayList<>();
        Categoria lst;
        //Sentencia SQL
        String sql = "SELECT categoria FROM categoria";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de datos
            while (rs.next()) {
                lst = new Categoria();
                lst.setCategoria(rs.getString(1));
                lscat.add(lst);
            }
            return lscat;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }
}
