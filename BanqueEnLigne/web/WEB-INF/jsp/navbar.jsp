<%-- 
    Document   : navbar
    Created on : 23 oct. 2018, 11:09:20
    Author     : nada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="inscription.jsp" class="navbar-brand" >MaBank</a>
                </div>
                <ul class="nav navbar-nav">
                    <li>
                        <form action ="accueil.htm" method="POST">
                            <button class="btn btn-secondary navbar-btn">Accueil</button>
                        </form>
                    </li>
                    <li>
                        <form action ="mesComptes.htm" method="POST">
                            <button class="btn btn-secondary navbar-btn">Mes comptes</button>
                        </form>
                    </li>
                    <li>
                        <form action ="ordreBourse.htm" method="POST">
                            <button class="btn btn-secondary navbar-btn">Ordre de bourse</button>
                        </form>
                    </li>
                    <li>
                        <form action ="virementAction.htm" method="POST">
                            <button class="btn btn-dark navbar-btn">Virement</button>
                        </form>
                    </li>
                    <li>
                        <form action ="creerCompte.htm" method="POST">
                            <button class="btn btn-dark navbar-btn">Créer un nouveau compte</button>
                        </form>
                    </li>
                    <li>
                        <form action ="nousContacter.htm" method="POST">
                            <button class="btn btn-secondary navbar-btn">Nous contacter</button>
                        </form>
                    </li>
                </ul>
            <button class="btn btn-danger navbar-btn">Se deconnecter</button>
            </div>
        </nav>
    </body>
</html>
