<%-- 
    Document   : inscription
    Created on : 25 oct. 2018, 16:39:15
    Author     : nada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div >
            <img class="d-block w-100" src="http://www.wexinc.com/wex-corporate/wp-content/uploads/sites/4/2017/04/WEX-Corporate-Bank-to-Bank-Large.jpg" alt="First slide" width="100%" height="300" >
        </div>
        <div class="col-xs-4">
        </div>
         <div class=" col-xs-4">
        <h1 style="">Bienvenue à MaBank</h1>
        <h1 style=""><br style=""> 
        </h1>
        <h3> Vous êtes : </h3>
        <form  action="inscriptionParticulier.htm" method="Post">
            <div class=" form-group col-xs-4 ">
                <input class="form-control btn-success" value="Un particulier" type="submit">
           </div>
        </form>
        <form  action="inscriptionProfessionnel.htm" method="Post">
            <div class=" form-group col-xs-4 ">
                <input class="form-control btn-success" value="Un Professionnel" type="submit">
           </div>
        </form>
    </body>
</html>
