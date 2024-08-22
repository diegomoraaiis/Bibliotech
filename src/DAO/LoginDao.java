package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author diego
 */
public class LoginDao {

    //Cadastro de usuário no banco de dados
    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException, IOException, ClassNotFoundException {
        if ((email != null) && (nome != null) && (senha != null)) {
            Connection conexao = JDBCUtil.getConnection();
            String sql = "INSERT INTO login (nome, email, senha)VALUES('" + nome + "','" + email + "','" + senha + "')";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            conexao.close();
        }
    }

    //verifica se o usuário é existente no banco e valida como usuário
    public String loginUser(String email, String senha) throws SQLException, ClassNotFoundException, IOException {
        Connection conexao = JDBCUtil.getConnection();
        String sql = "SELECT nome from login where email = '" + email + "' and senha = '" + senha + "'";
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            System.out.println("Usuário encontrado");
            return rs.getString("nome");
        } else {
            System.out.println("Usuário ou senha não encontrado");
            conexao.close();
        }
        conexao.close();
        return null;
    }

    //Verifica se o administrador é existente no banco e valida como administrador
    public String loginAdm(String email, String senha) throws SQLException, ClassNotFoundException, IOException {
        Connection conexao = JDBCUtil.getConnection();
        String sql = "SELECT nome from loginAdmin where email = '" + email + "' and senha = '" + senha + "'";
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            System.out.println("Usuário encontrado");
            return rs.getString("nome");
        } else {
            System.out.println("Usuário ou senha não encontrado");
            conexao.close();
        }
        conexao.close();
        return null;
    }
}
