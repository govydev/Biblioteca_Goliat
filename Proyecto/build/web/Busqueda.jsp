<%@page import="java.util.ArrayList"%>
<%@page import="biblioteca.bean.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Goliat - Busqueda</title>
        <link rel="stylesheet" href="CSS/estilos.css">
        <link rel="icon" type="image/jpeg" href="Icono/icon.jpeg" />
        <link rel="stylesheet" href="bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css">
        <script src="JS/jquery-3.4.0.min.js" type="text/javascript"></script>
        <script>
            function sesion(){
                alert("Para ver el Libro Online debes iniciar sesion...")
            }
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
                        url: 'MenuServlet',
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
                        url: 'MenuServlet',
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
                    <li role="presentation" ><a href="index">Inicio</a></li>
                    <li role="presentation" ><a href="Libros">Libros</a></li>
                    <li role="presentation" ><a href="Mangas">Mangas</a></li>
                    <li role="presentation" ><a href="Comics">Comics</a></li>
                    <li role="presentation" ><a href="Sesion">Inicio Sesion</a></li>
                </ul>
            </nav>
            <aside class="menu">
                <h2><label>Busqueda Profunda</label></h2><br>
                <label>G??nero :</label><br>
                <form id='opc1' method='post'>
                    <input type="text" value="gen" name="opc" hidden>
                    <select name="buspro" class="form-control" id="listGen">
                    </select><br>
                    <button type='button' class='btn btn-default' id='enviarO1'><label>Buscar por G??nero</label></button>
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
                    <%ArrayList<Producto> p = (ArrayList<Producto>) request.getAttribute("result");%>
                    <%for (Producto pro : p) {%>
                    <div class="portada">
                        <br><br>
                        <h1><label><u><%=pro.getTitulo()%></u></label></h1><br><br>
                        <img src="portada/<%=pro.getTitulo()%>.jpg" alt="<%=pro.getTitulo()%>">
                    </div>
                    <div class="Informacion">
                        <h2></h2>
                        <label>Autor                :   <%=pro.getAutor().getNombres()%> <%=pro.getAutor().getApellidos()%></label><br><br>
                        <label>Categoria            :   <%=pro.getGenero().getIdcategoria().getCategoria()%></label><br><br>
                        <label>Genero               :   <%=pro.getGenero().getGenero()%></label><br><br>
                        <label>Fecha de Publicacion :   <%=pro.getFechaPublicacion()%></label><br><br>
                    </div>
                    <div class="sinopsis">
                        <h2>Sinopsis</h2><br><br>
                        <p align="justify"><%=pro.getSinopsis()%></p>
                        <br>
                        <br>
                        <a class="btn btn-default" href="Sesion" onclick="sesion()"><label>Ver Libro Online</label></a>                
                    </div>
                    <%}%>
                </div>
            </section>
            <footer class="piePag">
                <label>@ 2019 - Derechos Reservados a Semillitas del Saber??</label>
            </footer>
        </div>
    </body>
</html>