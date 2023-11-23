package servlet;

import dao.CategoriaDAO;
import dao.ComentarioDAO;
import dao.UsuarioDAO;
import model.Categoria;
import model.Comentario;
import model.ComentarioTO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/create-comentario")

public class CreateComentarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String comentario = req.getParameter("comentario");
        String usuarioEmail = req.getSession().getAttribute("loggedUser").toString();
        String livro = req.getParameter("livro");
        int idCategoria = Integer.parseInt(req.getParameter("categoria"));

        Comentario comentarioObj = new Comentario(comentario, usuarioEmail, livro, idCategoria);

        boolean isComentario = new ComentarioDAO().inserirComentario(comentarioObj);

        if (isComentario) {

            preencheAtributosBase(req, usuarioEmail);
            req.setAttribute("sucessoComentario", "Comentário realizado com sucesso!!");

            req.getRequestDispatcher("logada/logada.jsp").forward(req, resp);

        } else {

            preencheAtributosBase(req, usuarioEmail);
            req.setAttribute("erroComentario", "Erro ao comentar, por favor tente novamente !!");

            req.getRequestDispatcher("logada/logada.jsp").forward(req, resp);

        }
    }

    private void preencheAtributosBase(HttpServletRequest req, String email) {
        Usuario usuarioLogado = new UsuarioDAO().buscarUsuario(email);
        ArrayList<Categoria> categorias = new CategoriaDAO().listarCategoria();
        ArrayList<Comentario> comentarios = new ComentarioDAO().listarComentario(email);
        List<ComentarioTO> comentarioView = preencherTO(comentarios);
        req.setAttribute("categorias", categorias);
        req.setAttribute("comentarios", comentarioView);
        req.setAttribute("usuarioLogado", usuarioLogado);

    }

    private List<ComentarioTO> preencherTO(ArrayList<Comentario> comentarios) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<ComentarioTO> comentarioView = new ArrayList<>();
        List<Usuario> usuarios = usuarioDAO.buscarUsuarios();

        for (Comentario comentario : comentarios) {
            for (Usuario usuario : usuarios) {
                if (comentario.getEmail().equals(usuario.getEmail())) {
                    comentarioView.add(new ComentarioTO(usuario.getNome(), comentario.getComentario(), usuario.getRedeSocial(), comentario.getLivro()));
                }
            }
        }
        return comentarioView;
    }

}
