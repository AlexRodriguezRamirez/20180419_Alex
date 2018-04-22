<%-- 
    Document   : finalizar
    Created on : 22-abr-2018, 19:00:17
    Author     : Alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resumen de su pedido</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <form action="controlador" method="POST">
            <table class="resultado">
                <tr>
                    <th>Título</th>
                    <th>Cantidad</th>
                </tr>
            
                <c:forEach var="Libro" items="${sessionScope.libros}">
                    <tr>
                        <td><c:out value="${Libro.titulo}"/></td>
                        <td><c:out value="${Libro.cantidad}"/><br></td>
                    </tr>
                </c:forEach>
                
                <tr>
                    <td><input type="submit" name="Volver" value="Volver"/></td>
                    <td><input type="submit" name="Pagar" value="Pagar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
