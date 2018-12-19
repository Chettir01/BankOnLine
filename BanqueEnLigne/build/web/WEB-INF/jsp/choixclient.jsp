<%-- 
    Document   : choixclient
    Created on : 1 nov. 2018, 23:22:06
    Author     : Julien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-xs-4">
        </div>
        <div class="form-group col-xs-4">
            <div class="col-xs-4">
            </div>
            
            <div class="col-xs-4">
             <h3>Vous êtes ?</h3>           
            <form action="creationclientparticulier.htm" method ="GET">
                <input class="form-control btn-success" Type="submit" VALUE="Particulier">
            </form>
            <br/>
            <form action="creationclientprofessionel.htm" method ="GET">
                <input class="form-control btn-success" Type="submit" VALUE="Professionel">
            </form>
            </div>
        </div>
    </body>
</html>
