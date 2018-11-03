<%-- 
    Document   : ajoutcompteclient
    Created on : 3 nov. 2018, 18:26:09
    Author     : Julien
--%>

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
        <div class="form-group col-xs-4 col-xs-offset-4">
            <form action="ajoutcompteclient.htm" method="POST">
                <div class="row">
                    <h3>Partager avec d'autres client de la banque</h3> 
                </div>
                <br/>
                <label>Login utilisateur : </label>
                <input class="form-control" type="text" name="login">
                <input class="form-control" type="hidden" name="compte" value="${compte}">
                <br/>
                <div class="row">
                    <div class=" form-group col-xs-4 col-xs-offset-4">
                        <input class="btn btn-success" type="submit" value="Partager" name="login">
                    </div>
                </div>

            </form>
        </div>
    </body>
</html>
