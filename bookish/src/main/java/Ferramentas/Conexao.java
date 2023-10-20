package Ferramentas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {


    public static Connection conectar() throws ClassNotFoundException, SQLException {

        Connection conexao = null;

        try {

            conexao = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso na conexão do banco de dados!");

        } catch (Exception e) {

            System.out.println("Falha na conexão do banco de dados!");

        }

        return conexao;

    }
}



