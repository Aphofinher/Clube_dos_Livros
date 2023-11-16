package servlet;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cadastra-dados")

public class CadastraDadosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        String nome = req.getParameter("nome");
        String instagram = req.getParameter("instagram");
        String categorias = req.getParameter("categorias");

        Usuario usuario = new Usuario(nome, instagram, categorias);

        new UsuarioDAO().inserirUsuario(usuario);

        req.getRequestDispatcher("index.jsp").forward(req, resp);


    }

}
