<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1 class="title">Ajouter un client</h1>
    <form action="addClient" method="post">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" required><br>

        <label for="adresse">Adresse : </label>
        <input type="text" id="adresse" name="adresse" required><br>

        <label for="email">Email :</label>
        <input type="email" id="email" name="email" required><br>

        <label for="telephone">Téléphone :</label>
        <input type="text" id="telephone" name="telephone" required><br>

        <input type="submit" value="Ajouter">
    </form>
</div>
</body>
</html>