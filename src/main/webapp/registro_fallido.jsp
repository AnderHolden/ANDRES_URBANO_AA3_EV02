<%-- 
    Document   : registro_fallido
    Created on : 10/09/2024, 11:05:56 p. m.
    Author     : Holden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro Fallido</title>
</head>
<body>
    <h2>Registro Fallido</h2>
    <p>Hubo un error al realizar el registro. Por favor, inténtelo de nuevo.</p>
    <p><strong><%= request.getAttribute("errorMessage") %></strong></p>
    <form action="index.html">
        <input type="submit" value="Volver a Intentar">
    </form>
</body>
</html>
