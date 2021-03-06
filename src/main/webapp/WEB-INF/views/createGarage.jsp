<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
	<form method="post" action="create">
		<table>
			<tr>
				<td>Nome da Garagem:</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>Sigla da Garagem:</td>
				<td><input type="text" name="initials" value="" /></td>
			</tr>
			<tr>
				<td>Selecione uma empresa:</td>
				<td><form:select path="company" items="${companyList}" multiple="true" />
				</td></tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add Garage"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><c:if test="${!empty message}">
						<c:out value="${message}" />
					</c:if></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="searchGarage">Consultar Garagens da Empresa</a></td>
			</tr>
		</table>
	</form>

</body>
</html>