package biblioteca.bean;

public class Genero {
    
    //Variable encapsuladas de los campos de la tabla genero
    private int idgenero;
    private String genero;
    private Categoria idcategoria;//Objetos de tipo categoria
    
    //Constructor de la clase sin parametros 
    public Genero() {
    }
    
    /*Constructor de la clase con los parametros genero de tipo cadena de texto 
    y un objeto tipo categoria*/
    public Genero(String genero, Categoria idcategoria) {
        this.genero = genero;
        this.idcategoria = idcategoria;
    }
    
    //Respectivos getters y setters de las variables
    public Genero(String genero) {
        this.genero = genero;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

}
