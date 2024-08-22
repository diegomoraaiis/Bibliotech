package Controller;

import DAO.DisponivelDao;
import Model.Disponivel;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class DisponivelController {

    //Controle de cadastro de livro
    public boolean cadastroLivro(Disponivel d) throws IOException, ClassNotFoundException {
        DisponivelDao disponivel = new DisponivelDao();
        if (disponivel.cadastrarLivro(d)) {
            return true;
        }
        return false;
    }

    //Controle de busca de livro
    public Disponivel buscarLivro(String titulo) throws IOException, ClassNotFoundException {
        DisponivelDao disponivel = new DisponivelDao();
        if (disponivel.buscarLivro(titulo) != null) {
            return disponivel.buscarLivro(titulo);
        } else {
            return null;
        }
    }

    //Controle de atualização de livro
    public boolean atualizarLivro(String tituloAlterar, Disponivel disponivel) throws SQLException, IOException, ClassNotFoundException {
        DisponivelDao disp = new DisponivelDao();
        if (disp.atualizarLivro(tituloAlterar, disponivel)) {
            return true;
        }
        return false;
    }

    //Controle de exclusão de livro
    public boolean excluirLivro(String titulo) throws IOException, ClassNotFoundException, SQLException {
        DisponivelDao disponivel = new DisponivelDao();
        if (disponivel.excluirLivros(titulo)) {
            return true;
        } else {
            return false;
        }
    }
}
