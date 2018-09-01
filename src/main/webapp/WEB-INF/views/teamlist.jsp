<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />

</head>
<body>
	<h1>List of Teams</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>View</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="t" items="${teams}">
				<tr>
					<td>${t.teamname}</td>
					<td><a class="btn btn-light btn-sm"
						href="/team/${t.teamid}/view">view</a></td>
					<td><a class="btn btn-light btn-sm"
						href="/team/${t.teamid}/edit">Edit</a></td>
					<td><a class="btn btn-light btn-sm" 
					onclick="return confirm('Are you sure you want to delete this item?');" href="/team/${t.teamid}/delete">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-secondary" href="/team/add">Add</a>
</body>
</html>