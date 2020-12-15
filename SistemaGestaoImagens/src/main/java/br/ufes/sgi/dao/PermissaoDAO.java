package br.ufes.sgi.dao;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissaoDAO {

    public void gerarCompartilhamento(Permissao permissao) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (permissao == null) {
            throw new Exception("Permissao não pode ser nulo!");
        }

        try {
            String SQL = "INSERT INTO permissao (idUsuario, idImagem, compartilhar,"
                    + " excluir, visualizar)"
                    + " values (?,?,?,?,?);";

            ps = conn.prepareStatement(SQL);

            ps.setInt(1, permissao.getUsuario().getId());
            ps.setInt(2, permissao.getImagem().getId());
            ps.setBoolean(3, permissao.isCompartilhar());
            ps.setBoolean(4, permissao.isExcluir());
            ps.setBoolean(5, permissao.isVisualizar());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public void excluir(Permissao permissao) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (permissao == null) {
            throw new Exception("Permissao não pode ser nulo!");
        }
        try {
            ps = conn.prepareStatement("delete from permissao where idPermissao = ?");
            ps.setInt(1, permissao.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

    }

    public void atualizar(Permissao permissao) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            //FIX-ME: essa query não vai atualizar todas as imagens desse user???
            String SQL = "UPDATE permissao SET compartilhar=?,"
                    + " visualizar=?, excluir = ?"
                    + "where (idImagem= ? and idUsuario = ?);";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, permissao.getImagem().getId());
            ps.setInt(2, permissao.getUsuario().getId());
            ps = conn.prepareStatement(SQL);
            ps.setBoolean(1, permissao.isCompartilhar());
            ps.setBoolean(2, permissao.isVisualizar());
            ps.setBoolean(3, permissao.isExcluir());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public boolean verificarPermissao(Usuario usuario, Imagem imagem) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("select idPermissao "
                    + "from permissao where permissao.idUsuario = ? "
                    + "and permissao.idImagem = ?; ");

            ps.setInt(1, usuario.getId());
            ps.setInt(2, imagem.getId());

            rs = ps.executeQuery();

            return rs.getRow() != 0;

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public Permissao getPermissao(int IdImagem, int idUsuario) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("select idPermissao, idUsuario, idImagem, compartilhar, "
                    + "excluir, visualizar "
                    + "from permissao where permissao.idUsuario = ? and permissao.idImagem = ?;");

            ps.setInt(1, idUsuario);
            ps.setInt(2, IdImagem);

            rs = ps.executeQuery();

            int idPermissao = rs.getInt(1);
            int idUser = rs.getInt(2);
            int idImagem = rs.getInt(3);
            boolean compartilhar = rs.getBoolean(4);
            boolean excluir = rs.getBoolean(5);
            boolean visualizar = rs.getBoolean(6);

            UsuarioDAO usuarioDAO = new UsuarioDAO();

            Usuario usuario;

            usuario = usuarioDAO.getById(idUser);

            ImagemDAO imagemDAO = new ImagemDAO();
            Imagem img = imagemDAO.getImagemById(idImagem);

            Permissao p = new Permissao(idPermissao, usuario, img, visualizar, excluir, compartilhar);
            return p;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public void gerarPedidoPermissao(Permissao permissao) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (permissao == null) {
            throw new Exception("Permissao não pode ser nulo!");
        }
        try {
            String SQL = "INSERT INTO permissao (idUsuario, idImagem)"
                    + " values (?,?);";

            ps = conn.prepareStatement(SQL);

            ps.setInt(1, permissao.getUsuario().getId());
            ps.setInt(2, permissao.getImagem().getId());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

}
