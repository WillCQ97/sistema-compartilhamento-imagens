package br.ufes.sgi.dao;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Solicitacao;
import br.ufes.sgi.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SolicitacaoDAO {

    public ArrayList<Solicitacao> getByIdAdmin(int id) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement("select * from solicitacao where solicitacao.idAdmin = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            ArrayList<Solicitacao> list = new ArrayList<>();

            while (rs.next()) {
                int idSolicitacao = rs.getInt(1);
                int idUsuario = rs.getInt(2);
                int idAdmin = rs.getInt(3);
                int idImagem = rs.getInt(4);
                String descricao = rs.getString(5);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                ImagemDAO imagemDAO = new ImagemDAO();

                Usuario admin = usuarioDAO.getById(idAdmin);
                Usuario usuario = usuarioDAO.getById(idUsuario);
                Imagem imagem = imagemDAO.getImagemById(idImagem);

                list.add(new Solicitacao(idSolicitacao, usuario, admin, imagem, descricao));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public void excluir(int id) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete * from Solicitacao where idSolicitacao= ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public void salvar(Solicitacao solicitacao) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            String SQL = "INSERT INTO Solicitacao (idUsuario, idAdmin, idImagem, descricao)"
                    + " values (?,?,?,?);";

            ps = conn.prepareStatement(SQL);

            ps.setInt(1, solicitacao.getUsuarioSolicitante().getId());
            ps.setInt(2, solicitacao.getAdminSolicitado().getId());
            ps.setInt(3, solicitacao.getImagem().getId());
            ps.setString(4, solicitacao.getDescricao());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

}
