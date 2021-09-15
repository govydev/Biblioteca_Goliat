package empleado.controlador;

import empleado.bean.Editorial;
import empleado.dao.EditorialDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEditorial", urlPatterns = {"/ServletEditorial", "/AgregarEditorial", "/ListarEditorial", "/EditarEditorial", "/GrabarEditorial", "/EliminarEditorial", "/NuevoEditorial"})
public class ServletEditorial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Path = request.getServletPath();
        //REDIRECCIONAR PARA EDITAR, AGREGAR, ELIMINAR Y LISTAR EDITORIAL
        if (Path.equals("/AgregarEditorial")) {
            request.setAttribute("l", new Editorial());
            request.getRequestDispatcher("WEB-INF/Administrador/formEditorial.jsp").forward(request, response);
        }
        if (Path.equals("/ListarEditorial")) {
            request.setAttribute("lista", new EditorialDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/listarEditorial.jsp").forward(request, response);
        }
        if (Path.equals("/EditarEditorial")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("e", new EditorialDao().buscar(id));
            request.getRequestDispatcher("WEB-INF/Administrador/formEditorial.jsp").forward(request, response);
        }
        if (Path.equals("/GrabarEditorial")) {
            String id = request.getParameter("id");
            Editorial editorial = new Editorial();
            editorial.setEditorial(request.getParameter("e"));
            if (id != "") {
                editorial.setIdeditorial(Integer.parseInt(id));
                new EditorialDao().modificar(editorial);
            } else {
                new EditorialDao().agregar(editorial);
            }
            response.sendRedirect("ListarEditorial");
        }
        if (Path.equals("/EliminarEditorial")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new EditorialDao().eliminar(id);
            response.sendRedirect("ListarEditorial");
        }
        if (Path.equals("/NuevoEditorial")) {
            request.getRequestDispatcher("WEB-INF/Administrador/formEditorial.jsp").forward(request, response);
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
