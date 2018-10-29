<%-- 
    Document   : listevirement
    Created on : 25 oct. 2018, 20:51:27
    Author     : Julien
--%>

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
        <h1>Mes virements</h1>
        <table>
            <tr>
                <th>Compte</th>
                <th>Iban</th> 
                <th>Date</th>
                <th>Somme</th>
            </tr>
            <%
                List<Virement> l = (List<Virement>) request.getAttribute("listevirement");
                if (l != null) {
                    for (int i = 0; i < l.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + l.get(i).getCompte().getID_compte() + "</td>");
                        out.print("<td>" + l.get(i).getIbandestination() + "</td>");
                        out.print("<td>" + l.get(i).getDatecreation().toString() + "</td>");
                        out.print("<td>" + l.get(i).getSomme() + "</td>");
                        out.print("</tr>");
                    }
                }
            %>
        </table>
        <form method='get' action='virement.htm'>
            <input class="form-control btn-success" Type="submit" VALUE="Nouveau virement">
        </form>
        <h1>Mes actions</h1>
        <table>
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
        </table>
        <form method='get' action='ordrebourse.htm'>
            <input class="form-control btn-success" Type="submit" VALUE="Acheter une action">
        </form>
    </body>
</html>
