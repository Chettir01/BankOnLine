<%-- 
    Document   : Virement
    Created on : 27 sept. 2018, 23:58:45
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
        
        <title>Virement</title>
    </head>
    <body>
         <div class="col-xs-4">
             <div class=" form-group col-xs-4 ">
                 <form action="detailscompte.htm" method="GET">
            <input class="form-control btn-info" Type=submit  VALUE="Retour"> 
                 </form>
             </div>
        </div>
        <div class="form-group col-xs-4">
            
           <form action="virement.htm" method ="POST">
               <div class="row">
               <div class="form-group col-xs-4">
               </div>
               <div class="form-group col-xs-4">
            <h2>Virement</h2> 
               </div>
            </div>
        
            <label for="Montant">Montant : </label>
            <input class="form-control" type="number" min="0" value="0" id="Montant" name="Montant"> 
            <br/>
            <label for="IBAN">IBAN : </label><input class="form-control"  type="text" id="IBAN" name ="IBAN"> <br/>
            <div class="row">
            <div class=" form-group col-xs-4 ">
            </div>
             <div class=" form-group col-xs-4 ">
            <input class="form-control btn-success"  Type=submit  VALUE="Effectuer"> 
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
