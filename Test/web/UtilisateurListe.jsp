<%-- 
    Document   : UtilisateurListe
    Created on : 8 déc. 2023, 14:15:58
    Author     : razaf
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Email</th>
                <th>Mot de passe</th>
            </tr>
            <%
                for(Utilisateur utilisateur : utilisateurs) { %>
                    <tr>
                        <td><% out.print(utilisateur.getEmail()); %></td>
                        <td><% out.print(utilisateur.getMotdepasse()); %></td>
                    </tr>
                <% }
            %>
        </table>
    </body>
</html>
