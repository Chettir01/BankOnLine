<%-- 
    Document   : creationOrdreBourse
    Created on : 29 oct. 2018, 19:10:22
    Author     : Julien
--%>

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
                <form action="accueille.jsp">
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
                <input class="form-control" type="select" id="bourse" name="bourse"> 
                <br/>
                <label for="type">type : </label>
                <input class="form-control" type="select"  id="type" name="type"> 
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
