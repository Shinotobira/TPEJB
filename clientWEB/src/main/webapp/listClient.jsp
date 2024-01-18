<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Clients</title>
</head>
<body>
<form>
<table border="1 solid black">
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Adresse</th>
        <th>Email</th>
        <th>Téléphone</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${listeClient}" var="client">
    <tr>
        <td>
                ${client.id}
        </td>
        <td>
                ${client.nom}
        </td>
        <td>
                ${client.prenom}
        </td>
        <td>
                ${client.adresse}
        </td>
        <td>
                ${client.email}
        </td>
        <td>
                ${client.telephone}
        </td>
        <td>
            <a href="http://localhost:8080/clientWEB/editClient?id=${client.id}"><button type="button" name="action" value="editClient">Modifier</button></a>
            <form action="clientServlet" method="post">
                <input type="hidden" name="clientId" value="${client.id}">
                <button type="submit" name="action" value="deleteClient" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce client ?')">Supprimer</button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>

<a href="http://localhost:8080/clientWEB/addClient"> <button type="button" name="action" value="addClient">Ajouté un client</button> </a>
</form>
</body>
</html>