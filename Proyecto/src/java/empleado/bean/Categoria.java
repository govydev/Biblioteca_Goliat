package empleado.bean;

public class Categoria {

    //Variables encapsuladas de los campos de la tabla categoria
    private int idcategoria;
    private String categoria;
    
    //Respectivos getters y setters de las variables
    public int getIdcategoria() {
        return idcategoria;
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
