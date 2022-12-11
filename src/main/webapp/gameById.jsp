<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<style type="text/css">
body  {
  background-image: url(<c:out value='${game.image}' />);
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light" style=" color: white; background-color: #3a3b3c">
	<div>
		<a class="navbar-brand"> Game Information </a>
	</div>
	<ul class="navbar-nav">
		<li><a style="color: grey;"
			href="<%=request.getContextPath()%>/GameServlet/dashboard"
			class="nav-link">Back to List of Games</a></li>
	</ul>
</nav>

<div style="text-align: center">
	
	<h1 style=" color: #D3d1c9; background: rgba(0,0,0,0.8);">
	<br>
			<c:out value='${game.name}' />
			<br><br>
			
	</h1>
		<p style=" color: #D3d1c9; background: rgba(0,0,0,0.7);">
			<br>
			<c:out value='${game.category}' />
			<br><br>
			<c:out value='${game.description}' />
		</p>
		
		
</div>


	<%-- 	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${game != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${game == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${game != null}">Edit User</c:if>
						<c:if test="${game == null}">Add New User</c:if>
					</h2>
				</caption>
				<c:if test="${game != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${game.name}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out
value='${game.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>category</label> <input type="text"
						value="<c:out
value='${game.category}' />" class="form-control"
						name="category">
				</fieldset>
				<fieldset class="form-group">
					<label>image</label>
					<input type="text"value="<c:out value='${game.image}' />" class="form-control" name="image">
				</fieldset>
				<fieldset class="form-group">
					<label>description</label> <input type="text"
						value="<c:out
value='${game.description}' />" class="form-control"
						name="description">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div> --%>
</body>
</html>