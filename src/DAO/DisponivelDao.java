package DAO;

/**
 *
 * @author anna moreira
 */
import Model.Disponivel;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisponivelDao {

    //Inserção de livro no banco de dados
    public boolean cadastrarLivro(Disponivel d) throws IOException, ClassNotFoundException {
        String sql = "INSERT INTO disponivel (titulo, autor, editora, genero, prateleira, quantidade, corredor) VALUES (?, ?, ?, ?, ?, ?,?)";
        try {
            try {
                JDBCUtil.init(new File(System.getProperty("user.dir") + "/src/DAO/bancoD.properties"));
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(DisponivelDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, d.getTitulo());
                preparedStatement.setString(2, d.getAutor());
                preparedStatement.setString(3, d.getEditora());
                preparedStatement.setString(4, d.getGenero());
                preparedStatement.setString(5, d.getPrateleira());
                preparedStatement.setInt(6, d.getQuantidade());
                preparedStatement.setString(7, d.getCorredor());
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //Recuperação de livros cadastrados no banco de dados
    public Disponivel buscarLivro(String titulo) throws IOException, ClassNotFoundException {
        Disponivel result = null;
        try {
            JDBCUtil.init(new File(System.getProperty("user.dir") + "/src/DAO/bancoD.properties"));
            PreparedStatement statement = JDBCUtil.getConnection().prepareStatement("SELECT * FROM disponivel WHERE titulo = ?");
            statement.setString(1, titulo);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = new Disponivel();
                result.setTitulo(rs.getString("titulo"));
                result.setAutor(rs.getString("autor"));
                result.setEditora(rs.getString("editora"));
                result.setGenero(rs.getString("genero"));
                result.setEditora(rs.getString("editora"));
                result.setPrateleira(rs.getString("prateleira"));
                result.setQuantidade(rs.getInt("quantidade"));
                result.setCorredor(rs.getString("corredor"));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DisponivelDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (JDBCUtil.getConnection() != null) {
                    JDBCUtil.getConnection().close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DisponivelDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return result;
    }

    //Atualização de livros no banco de dados
    public boolean atualizarLivro(String tituloAlterar, Disponivel disponivel) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE disponivel SET titulo = ?,autor =?, editora = ?, genero = ?, prateleira = ?, quantidade = ?,corredor = ? WHERE titulo = ?";
        try {
            JDBCUtil.init(new File(System.getProperty("user.dir") + "/src/DAO/bancoD.properties"));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DisponivelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement preparedStatement = JDBCUtil.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, disponivel.getTitulo());
            preparedStatement.setString(2, disponivel.getAutor());
            preparedStatement.setString(3, disponivel.getEditora());
            preparedStatement.setString(4, disponivel.getGenero());
            preparedStatement.setString(5, disponivel.getPrateleira());
            preparedStatement.setInt(6, disponivel.getQuantidade());
            preparedStatement.setString(7, disponivel.getCorredor());
            preparedStatement.setString(8, tituloAlterar);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    //Exclusão de livros no banco de dados
    public boolean excluirLivros(String tituloExcluir) throws IOException, ClassNotFoundException, SQLException {
        try {
            JDBCUtil.init(new File(System.getProperty("user.dir") + "/src/DAO/bancoD.properties"));
            PreparedStatement statement = JDBCUtil.getConnection().prepareStatement("delete  from disponivel where titulo = ?");
            statement.setString(1, tituloExcluir);
            statement.execute();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
}
