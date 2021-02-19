<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
				<td><c:out value="${vol.getVol_id()}" />" /></td>
				<td><c:out value="${vol.getAvion()}" />" /></td>
				<td><c:out value="${vol.getPilote()}" />" /></td>
				<td><c:out value="${vol.getVille_depart()}" />" /></td>
				<td><c:out value="${vol.getVille_arriver()}" />" /></td>
				
			<!-- 
				<td><input type="radio" name="livre_id" id="livre-<%= counter %>" value="<c:out value="${livres.getId()}" />" /></td>
				<td><label for="livre-<%= counter %>"><c:out value="${livres.getTitre()}" /></label></td>
				 -->
			</tr>
		
		</c:forEach>
		</tbody>
	</table>
	

</body>
</html>