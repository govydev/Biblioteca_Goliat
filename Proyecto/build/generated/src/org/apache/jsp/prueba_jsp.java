package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class prueba_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Goliat - PDF's</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/estilos.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/jpeg\" href=\"Icono/icon.jpeg\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"JS/jquery-3.4.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $.ajax({\n");
      out.write("                    url: 'PrincipalServlet',\n");
      out.write("                    type: 'GET',\n");
      out.write("                    success: function (res) {\n");
      out.write("                        $(\"#listx\").html(res);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                $.ajax({\n");
      out.write("                    url: 'LibrosServlet',\n");
      out.write("                    type: 'GET',\n");
      out.write("                    success: function (res) {\n");
      out.write("                        $(\"#libros\").html(res);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                $(\"#bus\").on(\"keyup\", function () {\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: 'BusquedaServlet',\n");
      out.write("                        type: 'POST',\n");
      out.write("                        data: $('#Buscar').serialize(),\n");
      out.write("                        success: function (datos) {\n");
      out.write("                            $(\"#libros\").html(datos);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"principal\">    \n");
      out.write("            <header class=\"encabezado\">\n");
      out.write("                <h1>GOLIAT</h1>\n");
      out.write("            </header>\n");
      out.write("            <nav class=\"navegador\">\n");
      out.write("                <ul class=\"nav nav-pills\">\n");
      out.write("                    <li role=\"presentation\" >\n");
      out.write("                        <form id=\"Buscar\" method=\"post\" class=\"navbar-form navbar-left\">\n");
      out.write("                            <select name=\"tipo\" class=\"form-control\">\n");
      out.write("                                <option value=\"Autor\">Autor</option>\n");
      out.write("                                <option value=\"Categoria\">Categoria</option>\n");
      out.write("                                <option value=\"Genero\">Genero</option>\n");
      out.write("                                <option value=\"Titulo\">Titulo</option>\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"text\" name=\"busqueda\" placeholder=\"Buscar\" class=\"form-control\" id=\"bus\" >\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"index\">Inicio</a></li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"Libros\">Libros</a></li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"Mangas\">Mangas</a></li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"Comics\">Comics</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <a href=\"ListarLibro\">Listar libros</a><br>\n");
      out.write("            <a href=\"ListarCliente\">Listar cliente</a><br>\n");
      out.write("            <a href=\"ListarEditorial\">Listar editorial</a><br>\n");
      out.write("            <a href=\"ListarGenero\">Listar género</a><br>\n");
      out.write("            <a href=\"ListarPais\">Listar país</a><br>\n");
      out.write("            <a href=\"ListarAutor\">Listar autor</a><br>\n");
      out.write("            <a href=\"ListarCategoria\">Listar categoria</a><br>\n");
      out.write("            <footer class=\"piePag\">\n");
      out.write("                <label>@ 2019 - Derechos Reservados a Semillitas del Saber©</label>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
