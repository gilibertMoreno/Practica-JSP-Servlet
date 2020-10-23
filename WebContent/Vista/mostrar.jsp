<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Automovil</title>
</head>
<body>
<h1>Lista  Automovil</h1>
	<table>
		<tr>
			<td><a href="AdminAutomovil?action=index" >Ir al menú</a> </td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td> ID_Vehiculo</td>
		 <td> PLACA</td>
		 <td> COLOR</td>
		 <td>MODELO</td>
		 <td>PROPIETARIO</td>
		 <td>VALOR</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="Automovil" items="${lista}">
			<tr>
				<td><c:out value="${Automovil.idautomovil}"/></td>
				<td><c:out value="${Automovil.placa}"/></td>
				<td><c:out value="${Automovil.color}"/></td>
				<td><c:out value="${Automovil.modelo}"/></td>
				<td><c:out value="${Automovil.propietario}"/></td>
				<td><c:out value="${Automovil.valor}"/></td>
				<td><a href="AdminAutomovil?action=showedit&id=<c:out value="${Automovil.idautomovil}" />">Editar</a></td>
				<td><a href="AdminAutomovil?action=eliminar&id=<c:out value="${Automovil.idautomovil}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
</body>
</html>