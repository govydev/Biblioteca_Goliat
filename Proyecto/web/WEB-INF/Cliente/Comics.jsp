
<%@page import="java.util.ArrayList"%>
<%@page import="biblioteca.bean.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Goliat - Comics</title>
        <link rel="stylesheet" href="CSS/estilos.css">
        <link rel="icon" type="image/jpeg" href="Icono/icon.jpeg" />
        <link rel="stylesheet" href="bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css">
        <script src="JS/jquery-3.4.0.min.js" type="text/javascript"></script>
        <script>
            $(function () {
                //AJAX
                //Lista de genero en busqueda profunda
                $.ajax({
                    url: 'GeneroServlet',
                    type: 'GET',
                    success: function (res) {
                        $("#listGen").html(res);
                    }
                });
                //Lista de autor en busqueda profunda
                $.ajax({
                    url: 'AutorServlet',
                    type: 'GET',
                    success: function (res) {
                        $("#listAut").html(res);
                    }
                });
                //Enviar el genero seleccionado para mostrar el resultado 
                $("#enviarO1").on("click", function () {
                    $.ajax({
                        url: 'MenuClienteServlet',
                        type: 'POST',
                        data: $('#opc1').serialize(),
                        success: function (datos) {
                            $("#libros").html(datos);
                        }
                    });
                });
                //Enviar el autor seleccionado para mostrar el resultado
                $("#enviarO2").on("click", function () {
                    $.ajax({
                        url: 'MenuClienteServlet',
                        type: 'POST',
                        data: $('#opc2').serialize(),
                        success: function (datos) {
                            $("#libros").html(datos);
                        }
                    });
                });
                //Muestra todos los productos disponibles
                $.ajax({
                    url: 'PrincipalServlet',
                    type: 'GET',
                    success: function (res) {
                        $("#listx").html(res);
                    }
                });
                //Realiza la busqueda por el titulo
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
    <body>
        <div class="principal">    
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
                    <li role="presentation" ><a href="Inicio.pe">Inicio</a></li>
                    <li role="presentation" ><a href="Libros.pe">Libros</a></li>
                    <li role="presentation" ><a href="Mangas.pe">Mangas</a></li>
                    <li role="presentation" class="active"><a href="Comics.pe">Comics</a></li>
                    <li role="presentation" ><a href="MiPerfil">Mi Perfil</a></li>
                    <li role="presentation" ><a href="Cerrar">Cerrar Sesion</a></li>
                </ul>
            </nav>
            <aside class="menu">
                <h2><label>Busqueda Profunda</label></h2><br>
                <label>Género :</label><br>
                <form id='opc1' method='post'>
                    <input type="text" value="gen" name="opc" hidden>
                    <select name="buspro" class="form-control" id="listGen">

                    </select><br>
                    <button type='button' class='btn btn-default' id='enviarO1'><label>Buscar por Género</label></button>
                </form>
                <br>
                <label>Autor :</label><br>
                <form id='opc2' method='post'>
                    <input type="text" value="aut" name="opc" hidden>
                    <select name="buspro" class="form-control" id="listAut">
                    </select><br>
                    <button type='button' class='btn btn-default' id='enviarO2'><label>Buscar por Autor</label></button>
                </form>
            </aside>
            <section class="productos">
                <div id="libros">
                    <table>
                        <%ArrayList<Producto> lista = (ArrayList<Producto>) request.getAttribute("lib");%>
                        <%for (Producto p : lista) {%>
                        <tr>
                            <th width="30%" style="text-align: center">
                                <img src="portada/<%=p.getTitulo()%>.jpg" alt="<%=p.getTitulo()%>" style="padding:20px; margin-right: auto; width: 50%"><br>
                            </th>
                            <th width="70%" align="left">
                                <h3 align="center"><a href="LibroWeb?id=<%=p.getIdproducto()%>"><%=p.getTitulo()%></a></h3><br>
                                <h4>Autor           : <%=p.getAutor().getNombres()%> <%=p.getAutor().getApellidos()%></h4>
                                <h4>Publicacion     : <%=p.getFechaPublicacion()%></h4>
                                <br>
                                <hr style="color: #262626">
                            </th>
                        </tr>
                        <%}%>
                    </table>
                </div>
            </section>
            <footer class="piePag">
                <label>@ 2019 - Derechos Reservados a Semillitas del Saber©</label>
            </footer>
        </div>
    </body>
</html>