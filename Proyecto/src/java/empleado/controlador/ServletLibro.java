package empleado.controlador;

import empleado.bean.Libro;
import empleado.dao.AutorDao;
import empleado.dao.EditorialDao;
import empleado.dao.GeneroDao;
import empleado.dao.LibroDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibroServlet", urlPatterns = {"/LibroServlet", "/AgregarLibro", "/ListarLibro", "/EditarLibro", "/GrabarLibro", "/EliminarLibro"})
public class ServletLibro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Path = request.getServletPath();
        //REDIRECCIONAR PARA EDITAR, AGREGAR, ELIMINAR Y LISTAR LIBROS
        if (Path.equals("/AgregarLibro")){
            request.setAttribute("aut", new AutorDao().listar());
            request.setAttribute("gen", new GeneroDao().listar());
            request.setAttribute("edi", new EditorialDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/formLibro.jsp").forward(request, response);
        }
        if (Path.equals("/ListarLibro")) {
            request.setAttribute("lista", new LibroDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/listarLibro.jsp").forward(request, response);
        }
        if (Path.equals("/EditarLibro")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("l", new LibroDao().buscar(id));
            request.setAttribute("aut", new AutorDao().listar());
            request.setAttribute("gen", new GeneroDao().listar());
            request.setAttribute("edi", new EditorialDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/formLibro.jsp").forward(request, response);
        }
        if (Path.equals("/GrabarLibro")) {
            String id = request.getParameter("id");
            Libro libro = new Libro();
            libro.setTitulo(request.getParameter("t"));
            libro.setFechaPublicacion(request.getParameter("f"));
            libro.setIdautor(Integer.parseInt(request.getParameter("ida")));
            libro.setIdeditorial(Integer.parseInt(request.getParameter("ide")));
            libro.setIdgenero(Integer.parseInt(request.getParameter("idg")));
            libro.setSinopsis(request.getParameter("p"));
            libro.setEnlace(request.getParameter("e"));
            if (id != "") {
                
                libro.setIdlibro(Integer.parseInt(id));
                new LibroDao().modificar(libro);
            } else {
                new LibroDao().agregar(libro);
            }
            response.sendRedirect("ListarLibro");
        }
        if (Path.equals("/EliminarLibro")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new LibroDao().eliminar(id);
            response.sendRedirect("ListarLibro");
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
