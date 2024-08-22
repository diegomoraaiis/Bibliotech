package Controller;

import DAO.LoginDao;
import View.Cadastro;
import View.Login;
import java.io.IOException;
import java.sql.SQLException;
import util.ValidacaoUtil;

/**
 *
 * @author diego
 */
public class LoginController {

    //Controle de Login(cadastro)
    public boolean cadastroUsuario(Cadastro view) throws SQLException, IOException, ClassNotFoundException {
        LoginDao cadastro = new LoginDao();
        ValidacaoUtil validacao = new ValidacaoUtil();
        if (validacao.validarEmail(view.getjTextFieldCadastroEmail().getText())) {
            String senha = new String(view.getjPasswordFieldSenha().getPassword());
            cadastro.cadastrarUsuario(view.getjTextFieldCadastroNome().getText(), view.getjTextFieldCadastroEmail().getText(), senha);
            return true;
        }
        return false;
    }

    //Controle de Login de usuário
    public String loginUsuario(Login view) throws SQLException, IOException, ClassNotFoundException {
        LoginDao login = new LoginDao();
        String senha = new String(view.getjPasswordFieldSenha().getPassword());
        login.loginUser(view.getjTextFieldUsuario().getText(), senha);
        String nome = login.loginUser(view.getjTextFieldUsuario().getText(), senha);
        if (nome != null) {
            return nome;
        }
        return null;
    }

    //Controle de login administrativo
    public String loginAdm(Login view) throws SQLException, IOException, ClassNotFoundException {
        LoginDao login = new LoginDao();
        String senha = new String(view.getjPasswordFieldSenha().getPassword());
        login.loginAdm(view.getjTextFieldUsuario().getText(), senha);
        String nome = login.loginAdm(view.getjTextFieldUsuario().getText(), senha);
        if (nome != null) {
            return nome;
        }
        return null;
    }
}
