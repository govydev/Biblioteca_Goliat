package biblioteca.DAO;

import biblioteca.bean.Pais;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaisDAO extends Conexion {

    //Funcion para listar los paises registrados
    public ArrayList<Pais> pais() {
        ArrayList<Pais> pais = new ArrayList<>();
        Pais p;
        //Sentencia SQL
        String sql = "select * from pais";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos encontrados
            while (rs.next()) {
                p = new Pais();
                p.setIdpais(rs.getInt(1));
                p.setPais(rs.getString(2));
                pais.add(p);
            }
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pais;
    }
}
