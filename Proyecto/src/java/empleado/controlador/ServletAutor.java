package empleado.controlador;

import empleado.bean.Autor;
import empleado.dao.AutorDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletAutor", urlPatterns = {"/ServletAutor", "/ListarAutor",
    "/EditarAutor", "/GrabarAutor", "/NuevoAutor", "/EliminarAutor"})
public class ServletAutor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Path = request.getServletPath();
        //REDIRECCIONAR PARA EDITAR, AGREGAR, ELIMINAR Y LISTAR AUTORES
        if (Path.equals("/ListarAutor")) {
            request.setAttribute("lista", new AutorDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/listarAutor.jsp").forward(request, response);
        }
        if (Path.equals("/EditarAutor")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("c", new AutorDao().buscar(id));
            request.getRequestDispatcher("WEB-INF/Administrador/formAutor.jsp").forward(request, response);
        }
        if (Path.equals("/GrabarAutor")) {
            String id = request.getParameter("id");
            Autor autor = new Autor();
            autor.setNombres(request.getParameter("n"));
            autor.setApellidos(request.getParameter("a"));
            if (id != "") {
                autor.setIdautor(Integer.parseInt(id));
                new AutorDao().modificar(autor);
            } else {
                new AutorDao().agregar(autor);
            }
            response.sendRedirect("ListarAutor");
        }
        if (Path.equals("/EliminarAutor")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new AutorDao().eliminar(id);
            response.sendRedirect("ListarAutor");
        }
        if (Path.equals("/NuevoAutor")) {
            request.getRequestDispatcher("WEB-INF/Administrador/formAutor.jsp").forward(request, response);
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
