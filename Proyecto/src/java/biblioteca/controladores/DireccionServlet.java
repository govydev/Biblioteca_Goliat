package biblioteca.controladores;

import biblioteca.DAO.ProductoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DireccionServlet", urlPatterns = {"/Libros", "/Comics", "/Mangas", "/LibroWeb",  "/LibroWebG", "/index", "/Sesion", "/Libros.pe", "/Comics.pe", "/Mangas.pe", "/MiPerfil", "/MiPerfilEmp", "/Inicio.pe", "/Cerrar"})
public class DireccionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        //REDIRECCIONES PARA EL USUARIO SIN INICIO DE SESION 
        if (path.equals("/Libros")) {
            request.setAttribute("libros", new ProductoDAO().listCat("Libro"));
            request.getRequestDispatcher("Libros.jsp").forward(request, response);
        }
        if (path.equals("/Comics")) {
            request.setAttribute("lib", new ProductoDAO().listCat("Comic"));
            request.getRequestDispatcher("Comics.jsp").forward(request, response);
        }
        if (path.equals("/Mangas")) {
            request.setAttribute("lib", new ProductoDAO().listCat("Manga"));
            request.getRequestDispatcher("Mangas.jsp").forward(request, response);
        }
        if (path.equals("/LibroWebG")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("result", new ProductoDAO().lista(id));
            request.getRequestDispatcher("Busqueda.jsp").forward(request, response);
        }
        //REDIRECCION A LA PAGINA PRINCIPAL
        if (path.equals("/index")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        //REDIRECCION PARA LA PAGINA DE INICIO DE SESION
        if (path.equals("/Sesion")) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        //REDIRECCION PARA LOS USUARIOS QUE INICIARON SESION
        if (path.equals("/Inicio.pe")) {
            request.getRequestDispatcher("WEB-INF/Cliente/Inicio.jsp").forward(request, response);
        }
        if (path.equals("/Libros.pe")) {
            request.setAttribute("libros", new ProductoDAO().listCat("Libro"));
            request.getRequestDispatcher("WEB-INF/Cliente/Libros.jsp").forward(request, response);
        }
        if (path.equals("/Comics.pe")) {
            request.setAttribute("lib", new ProductoDAO().listCat("Comic"));
            request.getRequestDispatcher("WEB-INF/Cliente/Comics.jsp").forward(request, response);
        }
        if (path.equals("/Mangas.pe")) {
            request.setAttribute("lib", new ProductoDAO().listCat("Manga"));
            request.getRequestDispatcher("WEB-INF/Cliente/Mangas.jsp").forward(request, response);
        }
        if (path.equals("/LibroWeb")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("result", new ProductoDAO().lista(id));
            request.getRequestDispatcher("WEB-INF/Busqueda.jsp").forward(request, response);
        }
        //REDIRECCION PARA EL PERFIL DEL USUARIO O CLIENTE
        if (path.equals("/MiPerfil")) {
            request.getRequestDispatcher("WEB-INF/PrincipalCliente.jsp").forward(request, response);
        }
        //REDIRECCION PARA EL PERFIL DE LOS EMPLEADOS O ADMINISTRADORES 
        if (path.equals("/MiPerfilEmp")) {
            request.getRequestDispatcher("WEB-INF/PrincipalEmpleado.jsp").forward(request, response);
        }
        //REDIRECCION PARA EL CIERRE DE SESION 
        if (path.equals("/Cerrar")) {
            HttpSession cerrar_session = request.getSession();
            cerrar_session.removeAttribute("cliente");
            cerrar_session.invalidate();
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
