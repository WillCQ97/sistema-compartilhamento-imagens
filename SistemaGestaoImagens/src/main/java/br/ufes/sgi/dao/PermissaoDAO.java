/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.dao;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 55289
 */
public class PermissaoDAO {

    private Connection conn;

    public PermissaoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public PermissaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void gerarCompartilhamento(Permissao permissao) throws Exception {
        PreparedStatement ps = null;

        if (permissao == null) {
            throw new Exception("Permissao não pode ser nulo!");
        }
        try {
            String SQL = "INSERT INTO Permissao (idUsuario,idImagem,compartilhar,"
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
        PreparedStatement ps = null;

        if (permissao == null) {
            throw new Exception("Permissao não pode ser nulo!");
        }
        try {
            ps = conn.prepareStatement("delete from Permissao where idPermissao = ?");
            ps.setInt(1, permissao.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

    }

    public void atualizarById(Permissao permissao) throws Exception {

        PreparedStatement ps = null;

        try {
            String SQL = "UPDATE Permissao SET compartilhar=?,"
                    + " visualizar=?, excluir = ?"
                    + "where idUsuarioLogin = ?;";

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

    public long verificaPermissao(Permissao permissao) throws Exception {
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select idPermissao"
                    + "from Permissao where Permissao.idUsuario = ? "
                    + "and Permissao.idImagem = ?;");
            ps.setInt(1, permissao.getId());
            rs = ps.executeQuery();
            int idPermissao = rs.getInt(1);
            Long idPermissaoFormatado = (long) idPermissao;

            return idPermissaoFormatado;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public Permissao getPermissaoByUsuario(Usuario usuario) throws Exception {
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select idUsuario, idPermissao, idImagem, compartilhar"
                    + "visualizar, excluir"
                    + "from Permissao where Permissao.idUsuario = ? ;");
            ps.setInt(1, usuario.getId());
            rs = ps.executeQuery();
            int idUsuario = rs.getInt(1);
            int idPermissao = rs.getInt(2);
            int idImagem = rs.getInt(3);
            boolean compartilhar = rs.getBoolean(4);
            boolean visualizar = rs.getBoolean(5);
            boolean excluir = rs.getBoolean(6);

            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
            Usuario user = usuarioDAO.getByID(idUsuario);

            ImagemDAO imagemDAO = new ImagemDAO(conn);
            Imagem img = imagemDAO.getImagemById(idImagem);

            Permissao permissao = new Permissao(idPermissao, user, img, visualizar, excluir, compartilhar);

            return permissao;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

}
