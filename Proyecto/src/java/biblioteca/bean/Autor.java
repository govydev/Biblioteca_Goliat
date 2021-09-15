package biblioteca.bean;

public class Autor {
    
    //Variables encapsuladas de los campos de la tabla autor
    private int idautor;
    private String nombres;
    private String apellidos;
    
    //Constructor sin parametro 
    public Autor() {
    }
    
    /*Constructor son paremetros nombre de tipo cadena de texto
    y apellido de tipo cadena de texto*/
    public Autor(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    //Respectivos getters y setters
    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
