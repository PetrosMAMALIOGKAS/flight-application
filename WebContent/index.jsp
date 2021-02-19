<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Bienvenu</h3>
	
	<form method="get" action="Control">
		<label for="lister">Lister des vols :</label>
		<input type="submit" id="lister" name="execute" value="lister" /><br/>
		<label for="ajouter-site">Ajouter un site de depart/arriver :</label>
		<input type="submit" id="ajouter-site" name="execute" value="ajouterSite" /><br/>
		<label for="gestion">Gestion des vols :</label>
	</form>
</body>
</html>