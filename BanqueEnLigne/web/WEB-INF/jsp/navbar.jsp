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
                    <a class="navbar-brand" >HIO Banque</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a >Accueil</a></li>
                        <li>
                            <form action ="monCompte.htm" method="POST">
                                <input Type=submit VALUE="Mon compte" > 
                            </form>
                        </li>
                    <li><a class="navbar-brand" href="<c:url value='/monCompte.jsp'/>"> <strong> NousRejoindre </strong></a></li>
                    <li><a >Mon ordre de bourse</a></li>
                    <li><a >Virement</a></li>
                    <li><a >Messagerie</a></li>
                    <li><a >Notification</a></li>
                </ul>
            <button class="btn btn-danger navbar-btn">Se deconnecter</button>
            </div>
        </nav>
    </body>
</html>
