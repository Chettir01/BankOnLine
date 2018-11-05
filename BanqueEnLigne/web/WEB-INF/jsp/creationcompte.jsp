<%-- 
    Document   : creationcompte
    Created on : 2 nov. 2018, 20:27:43
    Author     : Julien
--%>

<%@page import="DAO.TypeCompte"%>
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
        
        <form class="form-group col-xs-4 col-xs-offset-4" action="creationcompte.htm" method="POST">
            <h1>Demande de création de compte</h1>
            <br/>
            <label>Type de compte : </label>
            <select class="form-control" name="type">
                <option value="">"Nom" | "Taux"</option>
                <%
                    List<TypeCompte> lt = (List<TypeCompte>) request.getAttribute("listetypecompte");
                    if (lt != null) {
                        for (int i = 0; i < lt.size(); i++) {
                            if(!lt.get(i).getNom().equals("Banque gestion")){
                            out.print("<option value=\""+lt.get(i).getId()+"\">"+ lt.get(i).getNom()+" | "+ lt.get(i).getTaux()+"</option>");
                            }
                        }
                    }
                %>
            </select>
            <br/>
            <div class="col-xs-4 col-xs-offset-4">
             <input class="form-control btn-success" Type="submit" VALUE="Valider">
            </div>
        </form>
    </body>
</html>
