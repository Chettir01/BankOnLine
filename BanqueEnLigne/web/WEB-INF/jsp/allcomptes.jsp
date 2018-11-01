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
        <h1>Mes comptes</h1>
        <table>
            <tr>
                <th>Numéro de compte</th>
                <th>Date de création</th> 
                <th>Solde</th>
                <th>Type de compte</th>
                <th>Détails</th>
            </tr>
            <%

                List<Compte> l = (List<Compte>) request.getAttribute("listecompte");
                List<TypeCompte> lt = (List<TypeCompte>) request.getAttribute("listetypecompte");
                String typecompte = null;
                if (l != null && lt != null) {
                    System.out.println(l.size());
                    for (int i = 0; i < l.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + l.get(i).getNumcompte() + "</td>");
                        out.print("<td>" + l.get(i).getDateCreation() + "</td>");
                        out.print("<td>" + l.get(i).getSolde() + "</td>");
                        for (int j = 0; j < lt.size() && typecompte == null; j++) {
                            if (lt.get(j).getId() == l.get(i).getTypecompte().getId()) {
                                typecompte = lt.get(j).getNom();
                            }
                        }
                        if(typecompte == null){
                            typecompte="Pas de type";
                        }
                        out.print("<td>" + typecompte + "</td>");
                        out.print("<td>" + "<form action=\"detailscompte.htm\" method=\"get\">" + "<input type=\"hidden\" id=\"compte\" name=\"compte\" value=" + l.get(i).getID_compte() + " />" + "<input class=\"form-control btn-success\" Type=\"submit\" VALUE=\"Details\"/>" + "</form>" + "</td>");
                        out.print("</tr>");
                        typecompte=null;
                    }
                }
            %>
        </table>

    </body>
</html>
