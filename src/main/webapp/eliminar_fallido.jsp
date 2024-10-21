<%-- 
    Document   : eliminar_fallido
    Created on : 11/09/2024, 9:49:49 a. m.
    Author     : Holden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminación Fallida</title>
</head>
<body>
    <h2>Eliminación Fallida</h2>
    <p>Hubo un error al eliminar los datos. Por favor, inténtelo de nuevo.</p>
    <p><strong><%= request.getAttribute("errorMessage") %></strong></p>
    <form action="eliminar.jsp">
        <input type="submit" value="Volver a Intentar">
    </form>
</body>
</html>
