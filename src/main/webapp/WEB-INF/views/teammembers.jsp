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

<h1>Members from Selected Team</h1>

	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Role</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${member}">
				<tr>
					<td>${m.membername}</td>
					<td>${m.memberrole}</td>
					<td><a class="btn btn-light btn-sm"
						href="/member/${m.memberid}/edit">Edit</a></td>
					<td><a class="btn btn-light btn-sm" 
					onclick="return confirm('Are you sure you want to delete this Member?');" href="/member/${m.memberid}/delete">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-secondary" href="/member/add">Add MEMBER</a>
	<a href="/" class="btn btn-warning">GO BACK</a>
</body>
</html>