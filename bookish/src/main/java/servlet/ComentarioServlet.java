package servlet;

import dao.ComentarioDAO;
import model.Comentario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cadastra-comentario")
public class ComentarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //List<Comentario> comentario = new ComentarioDAO().listarComentario();

        //req.setAttribute("comentarios", comentario);

        req.getRequestDispatcher("logada/logada.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        String comentario = req.getParameter("comentario");
        int idCategoria = Integer.parseInt(req.getParameter("idCategoria"));

        // boolean isCadastrado = ComentarioDAO.inserirComentario(new Comentario(comentario, idUsuario, idCategoria));

        //if (isCadastrado) {
            // TODO lógica para sucesso no cadastro
        //} else {
            // TODO lógica para erro no cadastro
        //}
   }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getParameter("id"));
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        String comentario = req.getParameter("comentario");
        int idCategoria = Integer.parseInt(req.getParameter("idCategoria"));

       // boolean isAlterado = ComentarioDAO.editarComentario(new Comentario(id, comentario, idUsuario, idCategoria));

        //if (isAlterado) {
            // TODO lógica para sucesso no cadastro
        //} else {
            // TODO lógica para erro no cadastro
        //}
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getParameter("id"));



        boolean isExcluido = ComentarioDAO.excluirComentario(id);

        if (isExcluido) {
            // TODO lógica para sucesso no cadastro
        } else {
            // TODO lógica para erro no cadastro
        }

    }


}
