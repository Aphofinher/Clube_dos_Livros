package servlet;

import dao.ComentarioDAO;
import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletar-usuario")
public class DeletarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String email = req.getParameter("email");

        boolean isDeletedComent = new ComentarioDAO().excluirComentario(email);
        boolean isDeleted = new UsuarioDAO().excluirUsuario(email);

        if (isDeleted && isDeletedComent) {

            req.setAttribute("deletado", "Usuario excluído com sucesso! ");

            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } else {

            String usuarioEmail = req.getSession().getAttribute("loggedUser").toString();
            Usuario usuario = new UsuarioDAO().buscarUsuario(usuarioEmail);
            req.setAttribute("usuario", usuario);

            req.setAttribute("alteracao", "Erro na exlusão!");

            req.getRequestDispatcher("atualizar/atualizar.jsp").forward(req, resp);

        }

    }

}
