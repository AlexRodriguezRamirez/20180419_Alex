<%-- 
    Document   : salida.jsp
    Created on : 22-abr-2018, 20:57:40
    Author     : Alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra realizada</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <h3>Su compra se ha realizado con éxito.</h3>
        <h3>¡Gracias por confiar en nosotros!</h3>
        <a href="<c:out value="${pageContext.request.contextPath}" />">Volver a la tienda.</a>
    </body>
</html>
