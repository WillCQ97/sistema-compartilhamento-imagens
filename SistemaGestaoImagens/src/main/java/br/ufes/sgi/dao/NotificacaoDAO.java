package br.ufes.sgi.dao;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.model.Notificacao;
import br.ufes.sgi.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotificacaoDAO {

    public void salvarById(Notificacao notificacao) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (notificacao == null) {
            throw new Exception("Notificacao não pode ser nulo!");
        }
        try {
            String SQL = "INSERT INTO Notificacao (idUsuario,descricao)"
                    + " values (?,?);";

            ps = conn.prepareStatement(SQL);

            ps.setInt(1, notificacao.getUsuario().getId());
            ps.setString(2, notificacao.getDescricao());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public ArrayList<Notificacao> getNotificacaoById(int id) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select idINotificacao, descricao FROM Notificacao inner join UsuarioLogin "
                    + "on (Notificacao.idUsuarioLogin = Notificacao.idUsuarioLogin) where Notificacao.idUsuarioLogin = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            ArrayList<Notificacao> list = new ArrayList<>();

            while (rs.next()) {
                int idNotificacao = rs.getInt(1);
                int idUsuario = rs.getInt(2);
                String descricao = rs.getString(3);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.getById(idUsuario);

                list.add(new Notificacao(idNotificacao, usuario, descricao));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public void excluir(Notificacao notificacao) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (notificacao == null) {
            throw new Exception("Notificacao não pode ser nulo!");
        }
        try {
            ps = conn.prepareStatement("delete * from Notificacao where idNotificacao= ?");
            ps.setInt(1, notificacao.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }
}
