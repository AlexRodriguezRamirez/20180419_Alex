<%-- 
    Document   : index
    Created on : 21-abr-2018, 23:30:54
    Author     : Alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda de libros</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <h3>Seleccione el libro y la cantidad del mismo que desea comprar: </h3>
        
        <form action="controlador" method="POST">
            <select size="5" name="titulo">
                <option value="Juego de Tronos">Juego de Tronos</option>
                <option value="Los Pilares de la Tierra">Los Pilares de la Tierra</option>
                <option value="La Comunidad del Anillo">La Comunidad del Anillo</option>
                <option value="Las Dos Torres">Las Dos Torres</option>
                <option value="El Retorno del Rey">El Retorno del Rey</option>
            </select>
            <table>
                <tr>
                    <td><label for="cantidad">Cantidad: </label></td>
                    <td><input type="number" name="cantidad"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="Enviar" value="A&ntilde;adir"/></td>
                    <td><input type="submit" name="Finalizar" value="Finalizar compra"/></td>
                </tr>
            </table>
            
            <p class="error"><c:out value="${mensajeError}"/></p>
            <p class="mensaje"><c:out value="${mensaje}"/></p>
        </form>
    </body>
</html>
