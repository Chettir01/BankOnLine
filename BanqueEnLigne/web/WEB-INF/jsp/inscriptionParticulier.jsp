<%-- 
    Document   : inscription
    Created on : 26 sept. 2018, 09:37:21
    Author     : jberth08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription d'un particulier</title>
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
        <h1 style="">Formulaire d'inscription</h1>
        <h1 style=""><br style=""> 
        </h1>
       
        <form  action="inscriptionOnSuccesParticulier.htm" method="Post">
            <div class=" form-group">
            <label for="nom">Civilité : </label><SELECT name="civilite" size="1">
                                                    <OPTION>Mlle
                                                    <OPTION>Mme
                                                    <OPTION>Mr
                                                </SELECT> 
            </div>
            <div class=" form-group">
            <label for="nom">Nom : </label><input class="form-control" id="nom" name="nom" type="text"> 
            </div>
            <div class="form-group">
            <label for="prenom">Prenom : </label> <input id="prenom" class="form-control" name="prenom" type="text"> 
            </div>
            <div class="form-group">
            <label for="email">Adresse mail : </label><input id="email" class="form-control" name="email" type="text"> 
            </div>
           <div class="form-group">
            <label for="dateNaissance">Date de naissance : </label><input id="dateNaissance" class="form-control" name="dateNaissance" type="date"> 
            </div>
            <div class="form-group">
            <label for="adresse">Adresse : </label><input id="adresse" class="form-control" name="adresse" type="text"> 
            </div>
              <div class="form-group">
            <label for="tel">Téléphone : </label><input id="tel" class="form-control" name="tel" type="text"> 
            </div>
            <div class="form-group">
                <label for="typeCompte">Type Compte : </label> <SELECT name="typeCompte" size="1">
                                                                    <OPTION>Courant
                                                                    <OPTION>Livret
                                                                </SELECT> 
            </div>
           
            <div class="centered">
           <div class=" form-group col-xs-4 ">
            <input class="form-control btn-success" value="Se connecter" type="submit">
           </div>
            <div class=" form-group col-xs-4 ">
            <input class="form-control btn-danger btn-block" Type=reset VALUE="Annuler"> 
            </div>
             </div>
            </div>
        </div>
        </form>
        </div>
    </body>
</html>
