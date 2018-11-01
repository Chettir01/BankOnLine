<%-- 
    Document   : AccueilClient
    Created on : 17 oct. 2018, 15:38:00
    Author     : nada
--%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Accueil client</title>
    </head>
    <body>
        <div >
            <img class="d-block w-100" src="http://www.wexinc.com/wex-corporate/wp-content/uploads/sites/4/2017/04/WEX-Corporate-Bank-to-Bank-Large.jpg" alt="First slide" width="100%" height="300" >
        </div>
        <h1>${client.IDClient}</h1>
        <div>
            <menu type="context" id="popup-menu">
                <menuitem >
                <form action ="deconnexion.htm" method="GET">
                    <input class="btn btn-success btn-sm" Type=submit VALUE="Déconnection" > 
                </form> 
                </menuitem>
                <menuitem> 
                <form action ="allcomptes.htm" method="GET">
                    <input class="btn btn-primary btn-sm" Type=submit VALUE="Mes comptes" > 
                </form>
                </menuitem>
                <menuitem>
                <form action ="detailsclient.htm" method="GET">
                    <input class="btn btn-primary btn-sm" Type=submit VALUE="Mes informations" > 
                </form>
                </menuitem>
            </menu>
        </div>
    </body>
</html>
