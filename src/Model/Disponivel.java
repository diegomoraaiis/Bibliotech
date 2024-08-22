package Model;


public class Disponivel extends Livro {
    String prateleira;
    int quantidade;
    String corredor;


    public Disponivel() {
        prateleira = " ";
        quantidade = 0;
        corredor = " " ;
    }

    public Disponivel(String titulo, String autor, String editora, String genero, String prateleira, int quantidade, String corredor) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.prateleira = prateleira;
        this.quantidade = quantidade;
        this.corredor = corredor;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    @Override
    public String toString() {
        return "QUANTIDADE DISPONÍVEL..: "+ quantidade+"\n______________________________________\n"+"- TÍTULO..: "+titulo+"\n- AUTOR..: "+autor+"\n- EDITORA..: "+editora+ "\n- GÊNERO..: " + genero + "\n- CORREDOR...: " + corredor + "\n- PRATELEIRA..: " + prateleira + "\n______________________________________";
    }
    
    
}
