package Model;

// Ana Moreira


public class Livro {
    String titulo;
    String editora;
    String genero;
    String autor;


    public Livro() {}

    public Livro(String titulo, String editora, String genero, String autor){
        this.titulo = titulo;
        this.editora = editora;
        this.genero = genero;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }



}
