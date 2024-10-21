<%-- 
    Document   : dashboard
    Created on : 10/09/2024, 11:34:30 p. m.
    Author     : Holden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Bienvenido, <%= session.getAttribute("user") %></h2>
    <p>Opciones:</p>
    <ul>
        <li><a href="modificar.jsp">Modificar Datos</a></li>
        <li><a href="eliminar.jsp">Eliminar Datos</a></li>
        <li><a href="registro_nuevo.jsp">Registrar Nuevos Datos</a></li>
    </ul>
    <form action="LogoutServlet" method="post">
        <input type="submit" value="Cerrar Sesión">
    </form>
</body>
</html>
