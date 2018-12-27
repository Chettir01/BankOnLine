<%-- 
    Document   : AccueilClient
    Created on : 17 oct. 2018, 15:38:00
    Author     : nada
--%>

<%@page import="DAO.Compte"%>
<%@page import="DAO.Client"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
        <div>
            <div class="container col-xs-6 col-xs-offset-3">
                <div class="row">
                    <menu type="context" id="popup-menu">
                        <menuitem >
                        <form action ="deconnexionconseiller.htm" method="GET">
                            <input class="btn btn-success btn-sm" Type=submit VALUE="Déconnection" > 
                        </form> 
                        </menuitem> 
                        <menuitem>
                        <form action ="agios.htm" method="POST">
                            <input class="btn btn-danger btn-sm" Type=submit VALUE="AGIOS" > 
                        </form>
                        </menuitem>
                    </menu>
                </div>
                <div class="row">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h1>Comptes en attentes de validation</h1>
                        </div>
                        <div class="panel-body">

                            <table class="table table-bordered table-striped">
                                <thead>
                                <th>Id compte</th>
                                <th>Iban</th>
                                <th>Solde</th>
                                <th>Type compte</th>
                                <th>Taux %</th>
                                <th>Validation</th>
                                </thead>
                                <tbody>
                                    <%
                                        if (request.getAttribute("listecomptenonvalide") != null) {
                                            List<Compte> lt = (List<Compte>) request.getAttribute("listecomptenonvalide");

                                            for (int i = 0; i < lt.size(); i++) {
                                                out.print("<tr>");
                                                out.print("<td>" + lt.get(i).getID_compte() + "</td>");
                                                out.print("<td>" + lt.get(i).getIban() + "</td>");
                                                out.print("<td>" + lt.get(i).getSolde() + "</td>");
                                                out.print("<td>" + lt.get(i).getTypecompte().getNom() + "</td>");
                                                out.print("<td>" + lt.get(i).getTypecompte().getTaux() + "</td>");
                                                out.print("<td> <form action=\"validationcompte.htm\" method=\"POST\"> <input type=\"hidden\" id=\"id\" name=\"id\" value=\"" + lt.get(i).getID_compte() + "\" > <input class=\"btn btn-success\" type=\"submit\" value=\"Valider\"></form></td>");
                                                out.print("</tr>");
                                            }

                                        }

                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h1>Mes comptes</h1>
                        </div>
                        <div class="panel-body">

                            <table class="table table-bordered table-striped">
                                <thead>
                                <th>Id compte</th>
                                <th>Iban</th>
                                <th>Solde</th>
                                <th>Type compte</th>
                                <th>Taux %</th>
                                <th>Action</th>
                                </thead>
                                <tbody>
                                    <%            if (request.getAttribute("listecompte") != null) {
                                            List<Compte> l = (List<Compte>) request.getAttribute("listecompte");

                                            for (int i = 0; i < l.size(); i++) {
                                                out.print("<tr>");
                                                out.print("<td>" + l.get(i).getID_compte() + "</td>");
                                                out.print("<td>" + l.get(i).getIban() + "</td>");
                                                out.print("<td>" + l.get(i).getSolde() + "</td>");
                                                out.print("<td>" + l.get(i).getTypecompte().getNom() + "</td>");
                                                out.print("<td>" + l.get(i).getTypecompte().getTaux() + "</td>");
                                                if (l.get(i).isValide()) {
                                                    out.print("<td> <form action=\"cloturecompte.htm\" method=\"POST\"> <input type=\"hidden\" id=\"id\" name=\"id\" value=\"" + l.get(i).getID_compte() + "\" > <input class=\"btn btn-danger\" type=\"submit\" value=\"Cloturer\"></form></td>");
                                                } else {
                                                    out.print("<td> <form action=\"validationcompte.htm\" method=\"POST\"> <input type=\"hidden\" id=\"id\" name=\"id\" value=\"" + l.get(i).getID_compte() + "\" > <input class=\"btn btn-success\" type=\"submit\" value=\"Valider\"></form></td>");
                                                }
                                                out.print("</tr>");
                                            }

                                        }

                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h1>Tous les comptes</h1>
                        </div>
                        <div class="panel-body">
                            <table class="table table-bordered table-striped">
                                <thead>
                                <th>Id compte</th>
                                <th>Iban</th>
                                <th>Solde</th>
                                <th>Type compte</th>
                                <th>Taux %</th>
                                <th>Etat</th>
                                </thead>
                                <tbody>
                                    <%             if (request.getAttribute("toutcompte") != null) {
                                            List<Compte> ltout = (List<Compte>) request.getAttribute("toutcompte");

                                            for (int i = 0; i < ltout.size(); i++) {
                                                out.print("<tr>");
                                                out.print("<td>" + ltout.get(i).getID_compte() + "</td>");
                                                out.print("<td>" + ltout.get(i).getIban() + "</td>");
                                                out.print("<td>" + ltout.get(i).getSolde() + "</td>");
                                                out.print("<td>" + ltout.get(i).getTypecompte().getNom() + "</td>");
                                                out.print("<td>" + ltout.get(i).getTypecompte().getTaux() + "</td>");
                                                out.print("<td>" + ltout.get(i).isValide() + "</td>");
                                                out.print("</tr>");
                                            }

                                        }

                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
