package servlet;

import dao.ComentarioDAO;
import dao.UsuarioDAO;
import model.Comentario;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



    @WebServlet("/create-comentario")

    public class InserirComentarioServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

            String comentario = req.getParameter("comentario");
            String usuarioEmail = req.getParameter("email");
            String livro = req.getParameter("livro");
            int idCategoria = Integer.parseInt(req.getParameter("id-categoria"));

            Comentario comentarioObj = new Comentario(comentario, usuarioEmail, livro, idCategoria);

            boolean isComentario = new ComentarioDAO().inserirComentario(comentarioObj);


            if (isComentario) {

                req.getRequestDispatcher("logada.jsp").forward(req, resp);

            } else {


                req.setAttribute("erroComentario", "Erro ao comentar, por favor tente novamente !!");


                req.getRequestDispatcher("cadastro/cadastro.jsp").forward(req, resp);


            }


        }

}
