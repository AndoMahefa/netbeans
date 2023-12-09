<%-- 
    Document   : Utilisateur
    Created on : 8 déc. 2023, 07:58:40
    Author     : razaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UtilisateurController" method="POST">
            <p>Email : <input type="email" name="email" /></p>            
            <p>Mot de passe : <input type="password" name="motdepasse" /></p>
            <p><input type="submit" value="valider"></p>
        </form>
    </body>
</html>
