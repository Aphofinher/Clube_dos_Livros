package servlet;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-usuario")

public class CreateUsuarioServlet {

    //@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String usuarioEmail = req.getParameter("email");
        String usuarioSenha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("confirmaSenha");

        Usuario usuario = new Usuario(usuarioEmail, usuarioSenha);

         new UsuarioDAO().inserirUsuario(usuario);

        req.getRequestDispatcher("cadastro.html").forward(req, resp);

    }

}
