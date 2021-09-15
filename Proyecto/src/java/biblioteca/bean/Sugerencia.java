package biblioteca.bean;

public class Sugerencia {
    
    //Variables encapsuladas de los campos de la tabla Sugerencia
    private int idSugerencia;
    private String sugerencia;
    
    //Respectivas getter y setter de las variables encapsuladas
    public int getIdSugerencia() {
        return idSugerencia;
    }

    public void setIdSugerencia(int idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

}
