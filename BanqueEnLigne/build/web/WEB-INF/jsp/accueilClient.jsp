<%-- 
    Document   : accueilClient
    Created on : 16 oct. 2018, 12:17:30
    Author     : nada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil client</title>
    </head>
    <body>
        <h1>Page d'accueil client</h1>
        <P>${identif}</P></br></br></br>
        
        <form action="EffectuerVirement" method="get">
            <input class="btn btn-primary btn-sm" Type=submit VALUE="Effectuer un virement" > 
        </form>
        
        
    </body>
</html>
