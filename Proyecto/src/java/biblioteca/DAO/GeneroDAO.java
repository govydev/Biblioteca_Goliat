package biblioteca.DAO;

import biblioteca.bean.Genero;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDAO extends Conexion {

    //Funcion para listar Generos
    public ArrayList<Genero> listGenero() {
        ArrayList<Genero> lstgn = new ArrayList<>();
        Genero lst;
        //Sentencia SQL
        String sql = "SELECT genero FROM genero";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos encontrados
            while (rs.next()) {
                lst = new Genero();
                lst.setGenero(rs.getString(1));
                lstgn.add(lst);
            }
            return lstgn;
        } catch (SQLException e) {
            return null;
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

}
