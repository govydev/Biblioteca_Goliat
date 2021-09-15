package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import biblioteca.bean.Producto;

public final class Busqueda_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Goliat - Busqueda</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/estilos.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/jpeg\" href=\"Icono/icon.jpeg\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"JS/jquery-3.4.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $.ajax({\n");
      out.write("                    url: 'GeneroServlet',\n");
      out.write("                    type: 'GET',\n");
      out.write("                    success: function (res) {\n");
      out.write("                        $(\"#listGen\").html(res);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                $.ajax({\n");
      out.write("                    url: 'AutorServlet',\n");
      out.write("                    type: 'GET',\n");
      out.write("                    success: function (res) {\n");
      out.write("                        $(\"#listAut\").html(res);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                $(\"#enviarO1\").on(\"click\", function () {\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: 'MenuServlet',\n");
      out.write("                        type: 'POST',\n");
      out.write("                        data: $('#opc1').serialize(),\n");
      out.write("                        success: function (datos) {\n");
      out.write("                            $(\"#libros\").html(datos);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("                $(\"#enviarO2\").on(\"click\", function () {\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: 'MenuServlet',\n");
      out.write("                        type: 'POST',\n");
      out.write("                        data: $('#opc2').serialize(),\n");
      out.write("                        success: function (datos) {\n");
      out.write("                            $(\"#libros\").html(datos);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("                $.ajax({\n");
      out.write("                    url: 'PrincipalServlet',\n");
      out.write("                    type: 'GET',\n");
      out.write("                    success: function (res) {\n");
      out.write("                        $(\"#listx\").html(res);\n");
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
      out.write("                            <input type=\"text\" name=\"busqueda\" placeholder=\"Buscar de libro\" class=\"form-control\" id=\"bus\">\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"Inicio.pe\">Inicio</a></li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"Libros.pe\">Libros</a></li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"Mangas.pe\">Mangas</a></li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"Comics.pe\">Comics</a></li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"MiPerfil\">Mi Perfil</a></li>\n");
      out.write("                    <li role=\"presentation\" ><a href=\"Cerrar\">Cerrar Sesion</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <aside class=\"menu\">\n");
      out.write("                <h2><label>Busqueda Profunda</label></h2><br>\n");
      out.write("                <label>Género :</label><br>\n");
      out.write("                <form id='opc1' method='post'>\n");
      out.write("                    <input type=\"text\" value=\"gen\" name=\"opc\" hidden>\n");
      out.write("                    <select name=\"buspro\" class=\"form-control\" id=\"listGen\">\n");
      out.write("\n");
      out.write("                    </select><br>\n");
      out.write("                    <button type='button' class='btn btn-default' id='enviarO1'><label>Buscar por Género</label></button>\n");
      out.write("                </form>\n");
      out.write("                <br>\n");
      out.write("                <label>Autor :</label><br>\n");
      out.write("                <form id='opc2' method='post'>\n");
      out.write("                    <input type=\"text\" value=\"aut\" name=\"opc\" hidden>\n");
      out.write("                    <select name=\"buspro\" class=\"form-control\" id=\"listAut\">\n");
      out.write("                    </select><br>\n");
      out.write("                    <button type='button' class='btn btn-default' id='enviarO2'><label>Buscar por Autor</label></button>\n");
      out.write("                </form>\n");
      out.write("            </aside>\n");
      out.write("            <section class=\"productos\">\n");
      out.write("                <div id=\"libros\">\n");
      out.write("                    ");
ArrayList<Producto> p = (ArrayList<Producto>) request.getAttribute("result");
      out.write("\n");
      out.write("                    ");
for (Producto pro : p) {
      out.write("\n");
      out.write("                    <div class=\"portada\">\n");
      out.write("                        <br><br>\n");
      out.write("                        <h1><label><u>");
      out.print(pro.getTitulo());
      out.write("</u></label></h1><br><br>\n");
      out.write("                        <img src=\"portada/");
      out.print(pro.getTitulo());
      out.write(".jpg\" alt=\"");
      out.print(pro.getTitulo());
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"Informacion\">\n");
      out.write("                        <h2></h2>\n");
      out.write("                        <label>Autor                :   ");
      out.print(pro.getAutor().getNombres());
      out.write(' ');
      out.print(pro.getAutor().getApellidos());
      out.write("</label><br><br>\n");
      out.write("                        <label>Categoria            :   ");
      out.print(pro.getGenero().getIdcategoria().getCategoria());
      out.write("</label><br><br>\n");
      out.write("                        <label>Genero               :   ");
      out.print(pro.getGenero().getGenero());
      out.write("</label><br><br>\n");
      out.write("                        <label>Fecha de Publicacion :   ");
      out.print(pro.getFechaPublicacion());
      out.write("</label><br><br>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"sinopsis\">\n");
      out.write("                        <h2>Sinopsis</h2><br><br>\n");
      out.write("                        <p align=\"justify\">");
      out.print(pro.getSinopsis());
      out.write("</p>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <a class=\"btn btn-default\" href=\"https://books.google.es/books?hl=es&lr=&id=CPWlxufKqp4C&oi=fnd&pg=PA15&dq=don+quijote&ots=1sG_diqTXY&sig=fDjafmL8ROocf5XcFMyU50v6RUA#v=onepage&q=don%20quijote&f=false\">Ver libro</a>                </div>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <footer class=\"piePag\">\n");
      out.write("                <label>@ 2019 - Derechos Reservados a Semillitas del Saber©</label>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
