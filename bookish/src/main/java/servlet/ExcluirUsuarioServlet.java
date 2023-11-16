package servlet;

import dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/excluir-usuario")

public class ExcluirUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        String email = req.getParameter("email");


        new UsuarioDAO().excluirUsuario(email);


        req.setAttribute("confirma-exclusão", "Usuario excluido com sucesso!");


    }

}
