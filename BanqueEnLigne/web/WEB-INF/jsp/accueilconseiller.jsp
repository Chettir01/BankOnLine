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
            <menu type="context" id="popup-menu">
                <menuitem >
                <form action ="deconnexionconseiller.htm" method="GET">
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
                <menuitem>
                <form action ="agios.htm" method="POST">
                    <input class="btn btn-danger btn-sm" Type=submit VALUE="AGIOS" > 
                </form>
                </menuitem>
            </menu>
        </div>
        <h1>Comptes en attentes de validation</h1>
        <%
            if (request.getAttribute("listecomptenonvalide") != null) {
                List<Compte> lt = (List<Compte>) request.getAttribute("listecomptenonvalide");
                out.print("<table class=\"table\">");
                out.print("<thead>");
                out.print("<th>Id compte</th>");
                out.print("<th>Iban</th>");
                out.print("<th>Solde</th>");
                out.print("<th>Type compte</th>");
                out.print("<th>Taux %</th>");
                out.print("<th>Validation</th>");
                out.print("</thead>");
                out.print("<tbody>");
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
                out.print("</tbody>");
                out.print("</table>");
            }

        %>
        <h1>Mes comptes</h1>
        <%            if (request.getAttribute("listecompte") != null) {
                List<Compte> l = (List<Compte>) request.getAttribute("listecompte");
                out.print("<table class=\"table\">");
                out.print("<thead>");
                out.print("<th>Id compte</th>");
                out.print("<th>Iban</th>");
                out.print("<th>Solde</th>");
                out.print("<th>Type compte</th>");
                out.print("<th>Taux %</th>");
                out.print("<th>Action</th>");
                out.print("</thead>");
                out.print("<tbody>");
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
                out.print("</tbody>");
                out.print("</table>");
            }

        %>
        <h1>Tous les comptes</h1>
        <%             if (request.getAttribute("toutcompte") != null) {
                List<Compte> ltout = (List<Compte>) request.getAttribute("toutcompte");
                out.print("<table class=\"table\">");
                out.print("<thead>");
                out.print("<th>Id compte</th>");
                out.print("<th>Iban</th>");
                out.print("<th>Solde</th>");
                out.print("<th>Type compte</th>");
                out.print("<th>Taux %</th>");
                out.print("<th>Etat</th>");
                out.print("</thead>");
                out.print("<tbody>");
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
                out.print("</tbody>");
                out.print("</table>");
            }

        %>
    </body>
</html>
