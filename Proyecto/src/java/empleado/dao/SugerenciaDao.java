package empleado.dao;

import biblioteca.conexion.Conexion;
import empleado.bean.Sugerencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SugerenciaDao extends Conexion {
    
    //Funcion que lista las sugerencias hechas por los clientes 
    public ArrayList<Sugerencia> listSug() {
        ArrayList<Sugerencia> sugerencia = new ArrayList<>();
        Sugerencia sug;
        //Sentencia SQL
        String sql = "select * from sugerencia";
        cn = abrir();
        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            //Almacenamiento de los datos
            while (rs.next()) {
                sug = new Sugerencia();
                sug.setIdsugerencia(rs.getInt(1));
                sug.setSugerencia(rs.getString(2));
                sugerencia.add(sug);
            }
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        } catch (SQLException ex) {
            Logger.getLogger(SugerenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sugerencia;
    }
}
