package dao;

import config.ConnectionPoolConfig;
import model.Comentario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ComentarioDao {
    public static boolean inserirComentario(Comentario obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "INSERT INTO comentario (COMENTARIO, ID_USUARIO, ID_CATEGORIA, DATA_COMENTARIO) VALUES (?, ?, ?, ?)";

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, obj.getComentario());
            comandoSQL.setInt(2, obj.getIdUsuario());
            comandoSQL.setInt(3, obj.getIdCategoria());
            comandoSQL.setDate(4, Date.valueOf(obj.getDataComentario()));

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


    public static boolean editarComentario(Comentario obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "UPDATE comentario SET comentario = ?, id_categoria = ? WHERE id = ?";

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, obj.getComentario());
            comandoSQL.setInt(2, obj.getIdCategoria());
            comandoSQL.setInt(3, obj.getId());

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

    public static boolean excluirComentario(int id) {

        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("DELETE FROM comentario WHERE id = ?");

            comandoSQL.setInt(1, id);

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

    public static ArrayList<Comentario> listarComentario(int idUsuario, String categoria) {

        ArrayList<Comentario> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            // Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM comentario" +
                    " WHERE id_usuario = ? AND categoria = ? ORDER BY data_comentario DESC");

            comandoSQL.setInt(1, idUsuario);
            comandoSQL.setString(2, categoria);

            // Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Comentario obj = new Comentario();

                    obj.setId(rs.getInt("id"));
                    obj.setComentario(rs.getString("comentario"));
                    obj.setIdUsuario(rs.getInt("id_usuario"));
                    obj.setIdCategoria(rs.getInt("id_categoria"));
                    obj.setDataComentario(LocalDate.parse(rs.getDate("data_comentario").toString()));

                    //Passo o objeto para a lista de retorno
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
