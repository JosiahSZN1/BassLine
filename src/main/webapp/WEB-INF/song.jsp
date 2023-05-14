<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>Title: <c:out value="${song.title}"/></h1>
			<p>By: <c:out value=""/></p>
		</div>
		<div>
			<h2>Chorus: </h2>
			<p><c:out value="${song.chorus.lineA}"/></p>
			<p><c:out value="${song.chorus.lineB}"/></p>
			<p><c:out value="${song.chorus.lineC}"/></p>
			<p><c:out value="${song.chorus.lineD}"/></p>
			<a href="/${song.id}/chorus/new">Add a Chorus</a>
		</div>
		<div>
			<h2>Verse: </h2>
			<%-- <p><c:out value="${song.verse.lineA}"/></p>
			<p><c:out value="${song.verse.lineB}"/></p>
			<p><c:out value="${song.verse.lineC}"/></p>
			<p><c:out value="${song.verse.lineD}"/></p> --%>
			<a href="/${song.id}/verse/new">Add a Verse</a>
		</div>
	</div>
</body>
</html>