package dao;

import config.ConnectionPoolConfig;
import model.Comentario;

import java.sql.*;
import java.util.ArrayList;

public class ComentarioDAO {
    public boolean inserirComentario(Comentario obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "INSERT INTO comentario (COMENTARIO, EMAIL, ID_CATEGORIA, LIVRO) VALUES (?, ?, ?, ?)";

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, obj.getComentario());
            comandoSQL.setString(2, obj.getEmail());
            comandoSQL.setInt(3, obj.getIdCategoria());
            comandoSQL.setString(4, obj.getLivro());


            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return retorno;

    }




    public boolean excluirComentario(String email) {

        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("DELETE FROM comentario WHERE email = ?");

            comandoSQL.setString(1, email);

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return retorno;
    }

    public ArrayList<Comentario> listarComentario(String email) {

        ArrayList<Comentario> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM comentario" +
                    " WHERE email = ? ORDER BY ID DESC");

            comandoSQL.setString(1, email);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Comentario obj = new Comentario();

                    obj.setId(rs.getInt("id"));
                    obj.setComentario(rs.getString("comentario"));
                    obj.setEmail(rs.getString("email"));
                    obj.setLivro(rs.getString("livro"));
                    obj.setIdCategoria(rs.getInt("id_categoria"));



                    listaRetorno.add(obj);

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return listaRetorno;
    }

    public ArrayList<Comentario> listarComentario(int idCategoria) {

        ArrayList<Comentario> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM comentario" +
                    " WHERE ID_CATEGORIA = ? ORDER BY ID DESC");

            comandoSQL.setInt(1, idCategoria);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Comentario obj = new Comentario();

                    obj.setId(rs.getInt("id"));
                    obj.setComentario(rs.getString("comentario"));
                    obj.setEmail(rs.getString("email"));
                    obj.setLivro(rs.getString("livro"));
                    obj.setIdCategoria(rs.getInt("id_categoria"));


                    listaRetorno.add(obj);

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return listaRetorno;
    }
}
