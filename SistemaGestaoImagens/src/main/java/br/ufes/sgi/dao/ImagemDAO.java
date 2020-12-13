/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.dao;

import br.ufes.sgi.model.Imagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class ImagemDAO {

    private Connection conn;

    public ImagemDAO() throws Exception {
        try {
            this.conn = Conexao.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public ImagemDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Imagem> getAll() throws Exception {
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select * from Imagem");
            rs = ps.executeQuery();

            ArrayList<Imagem> list = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(1);
                String descricao = rs.getString(2);

                list.add(new Imagem(id, descricao));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao.fecharConexao(conn, ps, rs);
        }
    }

    public void salvar(Imagem imagem) throws Exception {
        PreparedStatement ps = null;

        if (imagem == null) {
            throw new Exception("Imagem não pode ser nulo!");
        }
        try {
            String SQL = "INSERT INTO Imagem (path)"
                    + " values (?);";

            ps = conn.prepareStatement(SQL);

            ps.setString(1, imagem.getPath());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            Conexao.fecharConexao(conn, ps);
        }
    }

    public void excluir(Imagem imagem) throws Exception {
        PreparedStatement ps = null;

        if (imagem == null) {
            throw new Exception("Imagem não pode ser nulo!");
        }
        try {
            ps = conn.prepareStatement("delete from imagem where idImagem = ?");
            ps.setInt(1, imagem.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            Conexao.fecharConexao(conn, ps);
        }

    }

    public ArrayList<Imagem> getImagensByIdUsuario(int id) throws Exception {
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select idImagem, path from Imagem inner join Permissao "
                    + "on (Permissao.idImagem = Imagem.idImagem) where Permissao.idUsuarioLogin = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            ArrayList<Imagem> list = new ArrayList<>();

            while (rs.next()) {
                int idImagem = rs.getInt(1);
                String path = rs.getString(2);

                list.add(new Imagem(id, path));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao.fecharConexao(conn, ps, rs);
        }
    }

    public Imagem getImagemById(int id) throws Exception {
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select Imagem.idImagem, Imagem.path from permissao "
                    + "inner join imagem on (Imagem.idImagem = ?)");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int idImagem = rs.getInt(1);
            String path = rs.getString(2);

            Imagem img = new Imagem(idImagem, path);
            
            return img;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao.fecharConexao(conn, ps, rs);
        }
    }
    
}
