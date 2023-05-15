<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Read Share</title>
</head>
<body>
	<div class="container">
		<div class="navbar d-flex justify-content between" style="display:flex; justify-content:space-between">
			<div>
				<h1>Welcome, <c:out value="${user.name}"/></h1>
				<p>Songs from everyone's shelves: </p>
			</div>
			<div style="display:flex; flex-direction:column; align-items:end">
				<a href="/logout">logout</a>
				<a href="/song/new">+ Write a new song</a>
			</div>
		</div>
		<div class="">
			<table class="table table-striped border border-3 border-dark">
				<thead style="background-color:rgb(204,204,204)">
					<tr>
						<th class="border border-3 border-dark border-bottom-0">ID</th>
						<th class="border border-3 border-dark border-bottom-0">Title</th>
						<th class="border border-3 border-dark border-bottom-0">Author Name</th>
						<th class="border border-3 border-dark border-bottom-0">Posted By</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${allBooks}">
						<tr>
							<td class="border border-3 border-dark border-top-0 border-bottom-0"><c:out value="${book.id}"/></td>
							<td class="border border-3 border-dark border-top-0 border-bottom-0"><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
							<td class="border border-3 border-dark border-top-0 border-bottom-0"><c:out value="${book.author}"/></td>
							<td class="border border-3 border-dark border-top-0 border-bottom-0"><c:out value="${book.user.name}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>