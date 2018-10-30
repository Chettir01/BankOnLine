<%-- 
    Document   : connexionconseiller
    Created on : 30 oct. 2018, 23:43:33
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
                <div >
            <img class="d-block w-100" src="http://www.wexinc.com/wex-corporate/wp-content/uploads/sites/4/2017/04/WEX-Corporate-Bank-to-Bank-Large.jpg" alt="First slide" width="100%" height="300" >
        </div>
        <div class="col-xs-4">
        </div>
        <div class="form-group col-xs-4">

           <form action="authconseiller.htm" method ="GET">
               <div class="row">
               <div class="form-group col-xs-4">
               </div>
               <div class="form-group col-xs-4">
            <h2>Connexion</h2> 
               </div>
            </div>
        
            <label>Identifiant  : </label> <input class="form-control" type="text" name="identifient"> 
            <br/>
            <label>Mot de passe : </label><input class="form-control" type="password" name ="password"> <br/>
            <div class="row">
                <div class=" form-group col-xs-4 ">
                </div>
                <div class=" form-group col-xs-4 ">
                    <input class="form-control btn-success" Type="submit" VALUE="Se connecter">
                    <input class="form-control btn-danger btn-block" Type=reset VALUE="Annuler"> 
                </div>
            </div>
        </form>
         </div>
    </body>
</html>
