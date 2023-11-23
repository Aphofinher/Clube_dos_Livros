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
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/login/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario usuario = new Usuario(email, senha);

        boolean isValidUser = new UsuarioDAO().verificaCredenciais(usuario);

        if (isValidUser) {
            req.getSession().setAttribute("loggedUser", email);
            buscaUsuarioLogado(req, email);
            preencheAtributosBase(req, email);

            req.getRequestDispatcher("logada/logada.jsp").forward(req, resp);

        } else {

            req.setAttribute("aviso", "Usuário ou senha inválidos!!");

            req.getRequestDispatcher("login/login.jsp").forward(req, resp);

        }

    }

    private void buscaUsuarioLogado(HttpServletRequest req, String email) {
        Usuario usuarioLogado = new UsuarioDAO().buscarUsuario(email);
        req.setAttribute("usuarioLogado", usuarioLogado);
    }

    private void preencheAtributosBase(HttpServletRequest req, String email) {
        ArrayList<Categoria> categorias = new CategoriaDAO().listarCategoria();
        ArrayList<Comentario> comentarios = new ComentarioDAO().listarComentario(email);
        List<ComentarioTO> comentarioView = preencherTO(comentarios);
        req.setAttribute("categorias", categorias);
        req.setAttribute("comentarios", comentarioView);
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
