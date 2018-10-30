<%--
  Created by IntelliJ IDEA.
  User: Julien
  Date: 10/10/2018
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <title>Détails</title>
    </head>
    <body>
        <div class=" form-group">
            <div class="col-xs-4">
            </div>
            <div class="form-group col-xs-4">
                <form method="post" action="detailsclient.htm">
                    <h1>Détails</h1>

                    <label >Login</label>
                    <input class="form-control" type="text" value="${login}"  name="login"> 


                    <label>mot de passe</label>
                    <input class="form-control" type="text" value="${mdp}" name="mdp"> 

                    <label >Adresse</label>
                    <input class="form-control" type="text" value="${adresse}" name="adresse"> 

                    <label >tel</label>
                    <input class="form-control" type="text" value="${tel}" name="tel"> 
                    <label >Type de client</label>
                    <input class="form-control" type="text" value="${type}" disabled="disabled" > 
                    <input class="form-control" type="hidden" value="${type}" name="type"> 
                    <%
                        if (request.getAttribute("type") != null) {
                            if (request.getAttribute("type").equals("PARTICULIER")) {
                                out.print("<label>Date de naissance</label>");
                                out.print("<input class=\"form-control\" type=\"date\" value=" + request.getAttribute("date") + "  name=\"date\">");
                                out.print("<label >prenom</label><input class=\"form-control\" type=\"text\" value=" + request.getAttribute("prenom") + "  name=\"prenom\"> ");
                                out.print("<label >Nom</label><input class=\"form-control\" type=\"text\" value=" + request.getAttribute("nom") + "  name=\"nom\"> ");
                                out.print("<label >Civilite</label><input class=\"form-control\" type=\"text\" value=" + request.getAttribute("civilite") + "  name=\"civilite\"> ");
                            }
                            if (request.getAttribute("type").equals("PROFESSIONEL")) {
                                out.print("<label>Nom de l'entreprise</label>");
                                out.print("<input class=\"form-control\" type=\"text\" value=" + request.getAttribute("entreprise") + "  name=\"entreprise\">");
                            }
                        }
                    %>



                    <br/>                  
                    <input class="form-control btn-success" Type="submit" VALUE="Modifier">

                </form>

            </div>
        </div>
    </body>
</html>
