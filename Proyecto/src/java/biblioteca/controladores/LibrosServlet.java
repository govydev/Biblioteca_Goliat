package biblioteca.controladores;

import biblioteca.DAO.ProductoDAO;
import biblioteca.bean.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibrosServlet", urlPatterns = {"/LibrosServlet"})
public class LibrosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //LISTA DE LOS PRODUCTOS(LIBROS, COMICS, MANGAS) DISPONIBLES
        out.println("<table>");
        for (Producto p : new ProductoDAO().listPro()) {
            out.println("<tr>");
            out.println("<td width=\"30%\" style=\"text-align: center\">");
            out.println("<img src=\"portada/" + p.getTitulo() + ".jpg\" alt=\"" + p.getTitulo() + "\" width=\"40%\"><br>");
            out.println("</td>");
            out.println("<th width=\"70%\" align=\"left\">");
            out.println("<h3 align=\"center\"><a href=\"LibroWebG?id=" + p.getIdproducto() + "\">" + p.getTitulo() + "</a></h3><br>");
            out.println("<h4>Autor           :&nbsp " + p.getAutor().getNombres() + " " + p.getAutor().getApellidos() + "</h4>");
            out.println("<h4>Publicacion     :&nbsp " + p.getFechaPublicacion() + "</h4>");
            out.println("<br>");
            out.println("<hr>");
            out.println("</th>");
            out.println("</tr>");
        }
        out.println("</table>");
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
