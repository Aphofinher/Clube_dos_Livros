package dao;

import Ferramentas.Conexao;
import model.Livros;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivrosDAO {

    public static boolean inserirLivro(Livros Obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "INSERT INTO livro SET  nome = ?, categoriaLivro = ?,"
                + " sinopse = ?, dataLivro = ?";


        try {

            conexao = Conexao.conectar();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setInt(1, Obj.getIdLivro());
            comandoSQL.setString(2, Obj.getNomeLivro());
            comandoSQL.setString(3, Obj.getCategoriaLivro());
            comandoSQL.setString(4, Obj.getSinopse());
            comandoSQL.setDate(5, Obj.getDataLivro());


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

    public static ArrayList<Livros> listarLivro(String nome) {

        ArrayList<Livros> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = Conexao.conectar();

            // Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM livro" +
                    " WHERE nome like ?" );

            comandoSQL.setString(1, nome);

            // Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Livros obj = new Livros();

                    obj.setIdLivro(rs.getInt("id"));
                    obj.setNomeLivro(rs.getString("nome"));
                    obj.setCategoriaLivro(rs.getString("categoriaLivro"));
                    obj.setSinopse(rs.getString("sinopse"));
                    obj.setDataLivro(rs.getDate("data"));



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


    public static boolean alterarLivro(Livros Obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "UPDATE livros SET nomeLivro = ?, categoriaLivro = ?,"
                + " sinopse = ?, dataLivro = ?"
                + " WHERE id = ?";


        try {

            conexao = Conexao.conectar();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);


            comandoSQL.setInt(1, Obj.getIdLivro());
            comandoSQL.setString(2, Obj.getNomeLivro());
            comandoSQL.setString(3, Obj.getCategoriaLivro());
            comandoSQL.setString(4, Obj.getSinopse());
            comandoSQL.setDate(5, Obj.getDataLivro());


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

    public static boolean excluirLivro(int id) {

        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = Conexao.conectar();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("DELETE FROM livros WHERE id = ?");

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

}
