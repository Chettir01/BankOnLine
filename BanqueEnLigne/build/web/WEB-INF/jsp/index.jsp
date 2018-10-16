<%-- 
    Document   : login.jsp
    Created on : 26 sept. 2018, 09:42:32
    Author     : nada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Ma Banque</title>
    </head>
    <body>
        <div class="col-xs-4">
        </div>
        <div class="form-group col-xs-4">
            <h1 >Bienvenue sur MaBanque</h1> <br/>
            <h2 align="center">Connectez-vous</h2>
            <div align="center">
                <form action ="RedirectConnexionClient" method="GET">
                    <input class="btn btn-primary btn-sm" Type=reset VALUE="Client" > 
                </form>
                <form action ="RedirectConnexionAdmin" method="GET">
                    <input class="btn btn-primary btn-sm" Type=reset VALUE="Admin" > 
                </form>     
            </div>
            
        </div>
    </body>
</html>

