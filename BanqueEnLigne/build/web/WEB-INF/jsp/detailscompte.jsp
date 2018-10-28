<%-- 
    Document   : listevirement
    Created on : 25 oct. 2018, 20:51:27
    Author     : Julien
--%>

<%@page import="DAO.Virement"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

                for (int i = 0; i < l.size(); i++) {
                    out.print("<tr>");
                    out.print("<td>" + l.get(i).getCompte().getID_compte() + "</td>");
                    out.print("<td>" + l.get(i).getDatecreation().toString() + "</td>");
                    out.print("<td>" + l.get(i).getSomme() + "</td>");
                    out.print("<td>" + "<form action=\"detailscompte.htm\" method=\"get\">" + "<input type=\"hidden\" name=\"compte\" value=\"\"/>"+"<input class=\"form-control btn-success\" Type=\"submit\" VALUE=\"Details\"/>"+ "</form>" + "</td>");
                    out.print("</tr>");
                }
                
            %>
        </table>
    </body>
</html>
