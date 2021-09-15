<%@page import="empleado.bean.Editorial"%>
<%@page import="empleado.bean.Autor"%>
<%@page import="empleado.bean.Genero"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Libro</title>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/jpeg" href="Icono/icon.jpeg" />
        <link rel="stylesheet" href="bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css">
        <script src="JS/jquery-3.4.0.min.js" type="text/javascript"></script>
        <script>
            $(function () {
                //AJAX
                //Busqueda de libro por titulo
                $("#bus").on("keyup", function () {
                    $.ajax({
                        url: 'BusquedaServlet',
                        type: 'POST',
                        data: $('#Buscar').serialize(),
                        success: function (datos) {
                            $("#libros").html(datos);
                        }
                    });
                });
            });
        </script>
    </head>
    <body><div class="principal">    
            <header class="encabezado">
                <h1>GOLIAT</h1>
            </header>
            <nav class="navegador">
                <ul class="nav nav-pills">
                    <li role="presentation" >
                        <form id="Buscar" method="post" class="navbar-form navbar-left">
                            <input type="text" name="busqueda" placeholder="Buscar de libro" class="form-control" id="bus">
                        </form>
                    </li>
                    <li role="presentation" ><a href="MiPerfilEmp">Mi Perfil</a></li>
                    <li role="presentation" ><a href="Cerrar">Cerrar Sesion</a></li>
                </ul>
            </nav>
            <aside class="menu">
                <label><h2>Listados</h2></label><br>
                <a href="ListarLibro" class='btn btn-default' >Libros</a><br><br>
                <a href="ListarCliente" class='btn btn-default'>Cliente</a><br><br>
                <a href="ListarEditorial" class='btn btn-default'>Editorial</a><br><br>
                <a href="ListarGenero" class='btn btn-default'>Género</a><br><br>
                <a href="ListarPais" class='btn btn-default'>País</a><br><br>
                <a href="ListarAutor" class='btn btn-default active'>Autor</a><br><br>
                <a href="ListarCategoria" class='btn btn-default'>Categoria</a><br><br>
                <a href="ListarSug" class='btn btn-default'>Sugerencia</a><br><br>
            </aside>
            <section class="productos">
                <div id="libros">
                    <br><br>
                    <h2>Formulario Libro</h2>
                    <br>
                    <form method="post" action="GrabarLibro">
                        <table>
                            <tr>
                                <td>Título<input name="id" type="hidden" value="${l.idlibro}"></td>
                                <td><input name="t" type="text"  class="form-control" value="${l.titulo}"><br></td>
                            </tr>
                            <tr>
                                <td>Autor</td>
                                <td>
                                    <select name="ida" class="form-control" >
                                        <%ArrayList<Autor> aut = (ArrayList<Autor>) request.getAttribute("aut");%>
                                        <%for (Autor a : aut) {%>
                                        <option value="<%=a.getIdautor()%>"><%=a.getNombres()%> <%=a.getApellidos()%></option>   
                                        <%}%>
                                    </select><br>
                                </td>
                            </tr>
                            <tr>
                                <td>Género</td>
                                <td>
                                    <select name="idg" class="form-control" >
                                        <%ArrayList<Genero> gen = (ArrayList<Genero>) request.getAttribute("gen");%>
                                        <%for (Genero c : gen) {%>
                                        <option value="<%=c.getIdcategoria()%>"><%=c.getGenero()%></option>
                                        <%}%>
                                    </select><br>
                                </td>
                            </tr>
                            <tr>
                                <td>Editorial</td>
                                <td>
                                    <select name="ide" class="form-control">
                                        <%ArrayList<Editorial> edi = (ArrayList<Editorial>) request.getAttribute("edi");%>
                                        <%for (Editorial e : edi) {%>
                                        <option value="<%=e.getIdeditorial()%>"> <%=e.getEditorial()%></option>  
                                        <%}%>
                                    </select><br>
                                </td>
                            </tr>
                            <tr>
                                <td>Fecha</td>
                                <td><input name="f" type="text"  class="form-control" placeholder="AAAA-MM-DD" value="${l.fechaPublicacion}"><br></td>
                            </tr>
                            <tr>
                                <td>Sinópsis</td>
                                <td><textarea name="p" class="form-control" style="height: 100px">${l.sinopsis}</textarea><br></td>
                            </tr>
                            <tr>
                                <td>Link</td>
                                <td><input name="e" type="text"  class="form-control" placeholder="Enlace" value="${l.enlace}"><br></td>
                            </tr>
                        </table>
                        <input type="submit" value="Grabar" class="btn btn-default">
                    </form>
                </div>
            </section>
            <footer class="piePag">
                <label>@ 2019 - Derechos Reservados a Semillitas del Saber©</label>
            </footer>
        </div>
    </body>
</html>