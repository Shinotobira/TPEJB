<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
<h1 class="title">Modifier client</h1>
<form action="editClient" method="post">
    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" value="${client.nom}"><br>

    <label for="prenom">Prénom :</label>
    <input type="text" id="prenom" name="prenom" value="${client.prenom}"><br>

    <label for="adresse">Adresse : </label>
    <input type="text" id="adresse" name="adresse" value="${client.adresse}"><br>

    <label for="email">Email :</label>
    <input type="email" id="email" name="email" value="${client.email}"><br>

    <label for="telephone">Téléphone :</label>
    <input type="text" id="telephone" name="telephone" value="${client.telephone}"><br>

    <input type="submit" value="Modifier">
</form>
</div>
</body>
</html>