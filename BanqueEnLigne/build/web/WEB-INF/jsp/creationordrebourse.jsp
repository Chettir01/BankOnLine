<%-- 
    Document   : creationOrdreBourse
    Created on : 29 oct. 2018, 19:10:22
    Author     : Julien
--%>

<%@page import="DAO.TypeOrdre"%>
<%@page import="DAO.TypeCompte"%>
<%@page import="DAO.Bourse"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-xs-4">
            <div class=" form-group col-xs-4 ">
                <form action="detailscompte.htm">
                    <input class="form-control btn-info" Type=submit  VALUE="Retour menu"> 
                </form>
            </div>
        </div>
        <div class="form-group col-xs-4">

            <form action="ordrebourse.htm" method ="POST">
                <div class="row">
                    <div class="form-group col-xs-4">
                    </div>
                    <div class="form-group col-xs-4">
                        <h2>Ordre de bourse</h2> 
                    </div>
                </div>
                <label>Prix action : ${prix}</label>
                <br/>
                <label for="Quantite">Quantite : </label>
                <input class="form-control" type="number" min="0" value="0" id="quantite" name="quantite"> 
                <br/>
                <label for="bourse">Bourse : </label>
                <select class="form-control" name="bourse">
                    <option value="">(Nom | Date Limite | Prix)</option>
                    <%
                        List<Bourse> l = (List<Bourse>) request.getAttribute("listebourse");
                        if (l != null) {
                            for (int i = 0; i < l.size(); i++) {
                                out.print("<option value=\"" + l.get(i).getId().toString() + "\" >" + l.get(i).getNom() + " | " + l.get(i).getDatelimite().toString() + " | " + l.get(i).getPrix() + "</option>");
                            }
                        }

                    %>
                </select> 
                <br/>
                <label for="type">type : </label>
                <select class="form-control" name="type">
                    <option value="">(Nom du type)</option>
                    <%                        List<TypeOrdre> lt = (List<TypeOrdre>) request.getAttribute("listetypecompte");
                        if (lt != null) {
                            for (int i = 0; i < lt.size(); i++) {
                                out.print("<option value=" + lt.get(i).getId().toString() + " >" + lt.get(i).getNom() + "</option>");
                            }
                        }
                    %>
                </select> 
                <br/>
                <div class="row">
                    <div class=" form-group col-xs-4 ">
                    </div>
                    <div class=" form-group col-xs-4 ">
                        <input class="form-control btn-success"  Type=submit  VALUE="Acheter"> 
                    </div>
                </div>

                <div class=" form-group col-xs-4 ">
                </div>
                <div class=" form-group col-xs-4 ">
                    <input class="form-control btn-danger btn-block" Type=reset VALUE="Annuler"> 
                </div>


            </form>
        </div>
    </body>
</html>
