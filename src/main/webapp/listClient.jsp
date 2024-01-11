<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Client</title>
</head>
<body>
<table border="1 solid black">
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Adresse</th>
        <th>mail</th>
        <th>tel</th>
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

    </tr>
    </c:forEach>
</table>
</body>
</html>