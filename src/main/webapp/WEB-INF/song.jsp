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
			<p>By: <c:forEach var="writer" items="${song.writers}"><c:out value="${writer.name}"/></c:forEach>
			
			</p>
			<c:if test="${!song.writers.contains(user)}">
				<a href="">Request collaboration</a>
			</c:if>
			
		</div>
		<div>
			<h3>Chorus: </h3>
			<p><c:out value="${song.chorus.lineA}"/></p>
			<p><c:out value="${song.chorus.lineB}"/></p>
			<p><c:out value="${song.chorus.lineC}"/></p>
			<p><c:out value="${song.chorus.lineD}"/></p>
			<c:if test="${song.writers.contains(user)}">
				<c:choose>
					<c:when test="${song.chorus == null}">
						<a href="/${song.id}/chorus/new">Add a Chorus</a>
					</c:when>
					<c:otherwise>
						<a href="">Edit Chorus</a>
					</c:otherwise>
				</c:choose>
			</c:if>
			
		</div>
		<div>
			<c:forEach var="verse" items="${song.verses}">
				<h4>Verse <c:out value="${song.verses.indexOf(verse) + 1}"/>:</h4>
				<p><c:out value="${verse.lineA}"/></p>
				<p><c:out value="${verse.lineB}"/></p>
				<p><c:out value="${verse.lineC}"/></p>
				<p><c:out value="${verse.lineD}"/></p> 
				<c:if test="${song.writers.contains(user)}">
					<a href="/${song.id}/verse/new">Edit Verse</a>
				</c:if>
			</c:forEach>
			<hr>
			<c:if test="${song.writers.contains(user)}">
				<a href="/${song.id}/verse/new">Add a Verse</a>
			</c:if>
			
		</div>
	</div>
</body>
</html>