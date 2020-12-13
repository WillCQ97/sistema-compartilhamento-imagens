/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.dao;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.model.Notificacao;
import br.ufes.sgi.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class NotificacaoDAO {

    private Connection conn;

    public NotificacaoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public NotificacaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvarById(Notificacao notificacao) throws Exception {
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
                Usuario usuario = usuarioDAO.getByID(idUsuario);
                

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
    
    
    
    

