/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.dao;

import br.ufes.sgi.model.Permissao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 55289
 */
public class PermissaoDAO {

    private Connection conn;

    public PermissaoDAO() throws Exception {
        try {
            this.conn = Conexao.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public PermissaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvarByIds(Permissao permissao) throws Exception {
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
            Conexao.fecharConexao(conn, ps);
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
            Conexao.fecharConexao(conn, ps);
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
            Conexao.fecharConexao(conn, ps);
        }
    }

}
