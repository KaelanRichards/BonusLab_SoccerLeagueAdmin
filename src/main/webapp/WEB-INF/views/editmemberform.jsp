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
	<div class="container">
		<h1>${ title }</h1>

		<!-- A form without an action submits back to the same URL, which is what we want here. -->
		<form method="post">
			<div class="form-group">
				<label for="membername">Name</label>
				<!-- pre-populate the input value from the existing food (if any) -->
				<input class="form-control" id="membername" name="membername"
					value="${member.membername}" required minLength="2" autocomplete="off">

			</div>
			<div class="form-group">
				<label for="memberrole">Role</label>
				<!-- pre-populate the input value from the existing food (if any) -->
				<input class="form-control" id="memberrole" name="memberrole"
					value="${member.memberrole}" required minLength="2" autocomplete="off">

			</div>
			

			<%-- <p>Select a Team:</p>
			<select name="teams">
				<c:forEach items="${teams}" var="t">
					<option value="${t.teamid}">${t.teamname}</option>
				</c:forEach>
			</select> <br />
			<br />  --%> 
			 <button type="submit" class="btn btn-primary">Submit</button>
			<a href="/" class="btn btn-link">Cancel</a>
		</form>




	</div>
</body>
</html>