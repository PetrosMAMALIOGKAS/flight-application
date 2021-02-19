<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List des vols</h1>
	<table>
		<thead>
			<tr>
				<th>Vol ID</th>
				<th>Avion</th>
				<th>Pilote</th>
				<th>Ville de Depart</th>
				<th>Ville d'arriver</th>
			</tr>
		</thead>
		 <tbody>
		<c:forEach var="vol" items="${listVols}">

			<tr>
				<td><c:out value="${vol.getVol_id()}"  /></td>
				<td><c:out value="${vol.getAvion()}"  /></td>
				<td><c:out value="${vol.getPilote()}"  /></td>
				<td><c:out value="${vol.getVille_depart().getVille()}"  /></td>
				<td><c:out value="${vol.getVille_arriver().getVille()}"  /></td>
				
			</tr>
		
		</c:forEach>
		</tbody>
	</table>
	

</body>
</html>