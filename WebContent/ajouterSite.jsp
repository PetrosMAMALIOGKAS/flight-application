<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Site</title>
</head>
<body>
	<h2>Ajouter un nouveau site de depart/arriver</h2>
	<br><br>
	<form action="Control" method="post">
		<label for="nouveau-site">Site à ajouter</label>
		<input type="text" name="ville" id="nouveau-site" />
		<br/>
		<input type="submit" name="execute" value="ajouterSite" />
	</form>

</body>
</html>