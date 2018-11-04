<%-- 
    Document   : comptes
    Created on : 25 oct. 2018, 20:45:05
    Author     : Julien
--%>


<%@page import="DAO.TypeCompte"%>
<%@page import="java.util.List"%>
<%@page import="DAO.Compte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <title>Compte</title>
    </head>
    <body>
        <div class="col-xs-1 ">
            <form action="accueil.htm" method="GET">
                <input class="form-control btn-info" Type=submit  VALUE="Retour"> 
            </form>
        </div>
        <div class="col-xs-6">
            <div class="panel panel-primary ">

                <div class="panel-heading">
                    <h1>Mes comptes</h1>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>Numéro de compte</th>
                            <th>Date de création</th>
                            <th>IBAN</th>
                            <th>Solde</th>
                            <th>Type de compte</th>
                            <th>Détails</th>
                            <th>Partage</th>
                        </tr>

                        <%

                            List<Compte> l = (List<Compte>) request.getAttribute("listecompte");
                            List<TypeCompte> lt = (List<TypeCompte>) request.getAttribute("listetypecompte");
                            if (l != null && lt != null) {
                                System.out.println(l.size());
                                for (int i = 0; i < l.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td>" + l.get(i).getID_compte() + "</td>");
                                    out.print("<td>" + l.get(i).getDateCreation() + "</td>");
                                    out.print("<td>" + l.get(i).getIban() + "</td>");
                                    out.print("<td>" + l.get(i).getSolde() + "</td>");
                                    out.print("<td>" + l.get(i).getType().getNom() + "</td>");
                                    if (l.get(i).isValide()) {
                                        out.print("<td>" + "<form action=\"detailscompte.htm\" method=\"get\">" + "<input type=\"hidden\" id=\"compte\" name=\"compte\" value=" + l.get(i).getID_compte() + " />" + "<input class=\"form-control btn-success\" Type=\"submit\" VALUE=\"Details\"/>" + "</form>" + "</td>");
                                    } else {
                                        out.print("<td>" + "<form action=\"detailscompte.htm\" method=\"get\">" + "<input type=\"hidden\" id=\"compte\" name=\"compte\" value=" + l.get(i).getID_compte() + " />" + "<input class=\"form-control btn-success\" Type=\"submit\" VALUE=\"Details\"  disabled/>" + "</form>" + "</td>");

                                    }
                                    out.print("<td>" + "<form action=\"ajoutcompteclient.htm\" method=\"get\">" + "<input type=\"hidden\" id=\"compte\" name=\"compte\" value=" + l.get(i).getID_compte() + " />" + "<input class=\"form-control btn-info\" Type=\"submit\" VALUE=\"Partager\"/>" + "</form>" + "</td>");
                                    out.print("</tr>");
                                }
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
