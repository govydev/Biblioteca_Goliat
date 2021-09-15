package biblioteca.DAO;

import biblioteca.bean.Sugerencia;
import biblioteca.conexion.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SugerenciaDAO extends Conexion {
    
    //Funcion que guarda todas las sugerencias hechas por el usuario 
    public void Sugerencia(Sugerencia S) {
        //Sentencia SQL
        String sql = "insert into sugerencia(sugerencia) value(?)";
        cn = abrir();
        try {
            //Envio de los datos para guardar los datos en la Base de Datos
            stm = cn.prepareStatement(sql);
            stm.setString(1, S.getSugerencia());
            stm.executeUpdate();
            cn.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(SugerenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
