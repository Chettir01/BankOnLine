<%-- 
    Document   : listevirement
    Created on : 25 oct. 2018, 20:51:27
    Author     : Julien
--%>

<%@page import="DAO.Compte"%>
<%@page import="DAO.OrdreBourse"%>
<%@page import="DAO.Virement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <title>JSP Page</title>
    </head>
    <body>

        <div class="col-xs-4 col-xs-offset-4 container">
            <div class="row">
                <div class="col-xs-3">
                    <form action="allcomptes.htm" method="GET">
                        <input class="form-control btn-info" Type=submit  VALUE="Retour"> 
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="panel panel-warning ">
                    <div class="panel-heading">
                        <h1>Mes virements</h1>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered table-striped">
                            <tr>
                                <th>Compte</th>
                                <th>Iban</th> 
                                <th>Date</th>
                                <th>Valeur</th>
                            </tr>
                            <%
                                List<Virement> l = (List<Virement>) request.getAttribute("listevirement");
                                if (l != null) {
                                    Compte c = (Compte) request.getAttribute("compte");
                                    if (c == null) {
                                        out.print("null");
                                    }
                                    for (int i = 0; i < l.size(); i++) {
                                        out.print("<tr>");
                                        out.print("<td>" + l.get(i).getCompte().getID_compte() + "</td>");
                                        if (c.getID_compte() == l.get(i).getIbandestination().getID_compte()) {
                                            out.print("<td >" + l.get(i).getCompte().getIban() + "</td>");
                                        } else {
                                            out.print("<td>" + l.get(i).getIbandestination().getIban() + "</td>");
                                        }

                                        out.print("<td>" + l.get(i).getDatecreation().toString() + "</td>");
                                        if (c.getID_compte() == l.get(i).getIbandestination().getID_compte()) {
                                            out.print("<td class=\"success\">" + "+ " + l.get(i).getSomme() + "</td>");
                                        } else {
                                            out.print("<td class=\"danger\">" + "- " + l.get(i).getSomme() + "</td>");
                                        }

                                        out.print("</tr>");
                                    }
                                }
                            %>
                            <tr>
                                <td colspan="4">
                                    <form method='get' action='virement.htm'>
                                        <input class="form-control btn-success " Type="submit" VALUE="Nouveau virement">
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="panel panel-warning ">
                    <div class="panel-heading">
                        <h1>Mes actions</h1>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered table-striped">
                            <tr>
                                <th>Compte</th>
                                <th>Date de création</th> 
                                <th>Date limite</th>
                                <th>Prix d'achat</th>
                                <th>Quantité</th>
                            </tr>
                            <%
                                List<OrdreBourse> lo = (List<OrdreBourse>) request.getAttribute("listeaction");
                                if (lo != null) {
                                    for (int i = 0; i < lo.size(); i++) {
                                        out.print("<tr>");
                                        out.print("<td>" + lo.get(i).getCompte().getID_compte() + "</td>");
                                        out.print("<td>" + lo.get(i).getDate_creation() + "</td>");
                                        out.print("<td>" + lo.get(i).getDateLimite() + "</td>");
                                        out.print("<td>" + lo.get(i).getPrixVente() + "</td>");
                                        out.print("<td>" + lo.get(i).getQuantite() + "</td>");
                                        out.print("</tr>");
                                    }
                                }
                            %>
                            <tr >
                                <td colspan="5">
                                    <form method='get' action='ordrebourse.htm'>
                                        <input class="form-control btn-success" Type="submit" VALUE="Acheter une action">
                                    </form>
                                </td>
                            </tr>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
