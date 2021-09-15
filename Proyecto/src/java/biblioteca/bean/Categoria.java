package biblioteca.bean;

public class Categoria {
    
    //Variable encapsuladas de los campos de la tabla Categoria
    private int idcategoria;
    private String categoria;

    //Respectivos getters y setters ed las varibles encapsuladas
    public int getIdcategoria() {
        return idcategoria;
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    public Categoria() {
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
